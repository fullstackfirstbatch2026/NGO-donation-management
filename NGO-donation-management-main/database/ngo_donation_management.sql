CREATE DATABASE IF NOT EXISTS ngo_donation_management;
USE ngo_donation_management;

DROP TRIGGER IF EXISTS trg_update_campaign_amount;
DROP PROCEDURE IF EXISTS record_donation;
DROP FUNCTION IF EXISTS calculate_campaign_donation_total;

DELIMITER $$

CREATE TRIGGER trg_update_campaign_amount
AFTER INSERT ON donations
FOR EACH ROW
BEGIN
    UPDATE campaigns
    SET donation_amount = donation_amount + NEW.amount
    WHERE campaign_id = NEW.campaign_id;
END$$

CREATE PROCEDURE record_donation(
    IN p_donor_id BIGINT,
    IN p_campaign_id BIGINT,
    IN p_amount DECIMAL(12,2),
    IN p_payment_method VARCHAR(40),
    IN p_note VARCHAR(500)
)
BEGIN
    IF p_amount IS NULL OR p_amount <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Donation amount must be greater than zero';
    END IF;

    IF NOT EXISTS (SELECT 1 FROM donors WHERE donor_id = p_donor_id) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Donor not found';
    END IF;

    IF NOT EXISTS (SELECT 1 FROM campaigns WHERE campaign_id = p_campaign_id) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Campaign not found';
    END IF;

    INSERT INTO donations(donor_id,campaign_id,amount,payment_method,note,donated_at)
    VALUES(p_donor_id,p_campaign_id,p_amount,p_payment_method,p_note,NOW());
END$$

CREATE FUNCTION calculate_campaign_donation_total(p_campaign_id BIGINT)
RETURNS DECIMAL(12,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_total DECIMAL(12,2);
    SELECT COALESCE(SUM(amount),0) INTO v_total
    FROM donations WHERE campaign_id=p_campaign_id;
    RETURN v_total;
END$$

DELIMITER ;

-- After running this script, refresh the application.
-- The trigger also updates campaigns.donation_amount for future donations.
-- If seed donations were inserted before the trigger existed, sync them with:
UPDATE campaigns c
SET donation_amount = (
    SELECT COALESCE(SUM(d.amount),0) FROM donations d WHERE d.campaign_id=c.campaign_id
);

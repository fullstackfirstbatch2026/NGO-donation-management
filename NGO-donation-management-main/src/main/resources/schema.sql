CREATE TABLE IF NOT EXISTS donors (
 donor_id BIGINT NOT NULL AUTO_INCREMENT, donor_name VARCHAR(100) NOT NULL, email VARCHAR(150) NOT NULL,
 phone VARCHAR(30), address VARCHAR(255), created_at DATETIME, PRIMARY KEY(donor_id), UNIQUE KEY uk_donor_email(email)
);
CREATE TABLE IF NOT EXISTS campaigns (
 campaign_id BIGINT NOT NULL AUTO_INCREMENT, campaign_name VARCHAR(150) NOT NULL, description VARCHAR(500),
 target_amount DECIMAL(12,2), donation_amount DECIMAL(12,2) NOT NULL DEFAULT 0,
 start_date DATE, end_date DATE, PRIMARY KEY(campaign_id)
);
CREATE TABLE IF NOT EXISTS donations (
 donation_id BIGINT NOT NULL AUTO_INCREMENT, donor_id BIGINT NOT NULL, campaign_id BIGINT NOT NULL,
 amount DECIMAL(12,2) NOT NULL, payment_method VARCHAR(40), note VARCHAR(500), donated_at DATETIME,
 PRIMARY KEY(donation_id), CONSTRAINT fk_donation_donor FOREIGN KEY(donor_id) REFERENCES donors(donor_id),
 CONSTRAINT fk_donation_campaign FOREIGN KEY(campaign_id) REFERENCES campaigns(campaign_id)
);
CREATE TABLE IF NOT EXISTS volunteers (
 volunteer_id BIGINT NOT NULL AUTO_INCREMENT, volunteer_name VARCHAR(100) NOT NULL,
 email VARCHAR(150) NOT NULL, phone VARCHAR(30), skills VARCHAR(255), PRIMARY KEY(volunteer_id),
 UNIQUE KEY uk_volunteer_email(email)
);
INSERT IGNORE INTO donors(donor_id,donor_name,email,phone,address,created_at) VALUES
(1,'Arun Kumar','arun.donor@gmail.com','9876543210','Chennai',NOW()),
(2,'Priya Sharma','priya.donor@gmail.com','9876543211','Bengaluru',NOW()),
(3,'Karthik Raman','karthik.donor@gmail.com','9876543212','Coimbatore',NOW()),
(4,'Divya Menon','divya.donor@gmail.com','9876543213','Chennai',NOW()),
(5,'Rahul Patel','rahul.donor@gmail.com','9876543214','Madurai',NOW());
INSERT IGNORE INTO campaigns(campaign_id,campaign_name,description,target_amount,donation_amount,start_date,end_date) VALUES
(1,'Clean Water Mission','Safe drinking water for rural communities',100000,0,'2026-01-01','2026-12-31'),
(2,'Education for Every Child','Learning materials and scholarships',75000,0,'2026-02-01','2026-11-30'),
(3,'Food Relief Drive','Monthly food support for families',50000,0,'2026-03-01','2026-12-31'),
(4,'Green Village','Tree planting and village restoration',60000,0,'2026-04-01','2026-12-31');
INSERT IGNORE INTO donations(donation_id,donor_id,campaign_id,amount,payment_method,note,donated_at) VALUES
(1,1,1,15000,'UPI','Water filters', '2026-09-10 10:00:00'),
(2,2,2,25000,'CARD','School kits', '2026-09-12 11:30:00'),
(3,3,1,18000,'UPI','Community well', '2026-09-15 09:20:00'),
(4,4,3,8000,'BANK','Food packages', '2026-09-18 14:10:00'),
(5,1,2,12000,'UPI','Scholarship support', '2026-09-20 16:00:00'),
(6,5,4,10000,'CARD','Saplings', '2026-09-22 13:45:00');
INSERT IGNORE INTO volunteers(volunteer_id,volunteer_name,email,phone,skills) VALUES
(1,'Ananya Rao','ananya.volunteer@gmail.com','9000000001','Teaching'),
(2,'Vikram Singh','vikram.volunteer@gmail.com','9000000002','Fundraising'),
(3,'Meena Iyer','meena.volunteer@gmail.com','9000000003','Medical Support');
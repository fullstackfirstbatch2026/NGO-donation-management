# NGO Donation Management

A beginner-friendly Spring Boot project matching the College Course Registration project style.

## Requirements covered
- DONORS, CAMPAIGNS, DONATIONS, VOLUNTEERS
- JOIN: donations with donor and campaign information
- SUBQUERY: donors whose total donation is above the average donation
- STORED PROCEDURE: `record_donation`
- FUNCTION: `calculate_campaign_donation_total`
- TRIGGER: `trg_update_campaign_amount`
- REST API
- Attractive responsive frontend

## Technology
Java 21, Spring Boot 4.1.1, Spring Data JPA, MySQL, HTML/CSS/JavaScript, Maven.

## Run
1. Create/use MySQL.
2. Set your MySQL root password as environment variable `DB_PASSWORD`.
3. Run `database/ngo_donation_management.sql` in MySQL Workbench. This creates the procedure, function and trigger.
4. Open PowerShell in this folder and run:
   `mvnw.cmd spring-boot:run`
5. Open:
   `http://localhost:8091`

## Important
The application creates the four tables and sample data automatically. The SQL objects are kept in `database/ngo_donation_management.sql` because MySQL Workbench uses `DELIMITER` for procedure/function/trigger creation.

## Main REST endpoints
GET /api/donors
POST /api/donors
GET /api/campaigns
POST /api/campaigns
GET /api/volunteers
POST /api/volunteers
GET /api/donations
GET /api/donations/join-report
GET /api/donations/above-average
POST /api/donations
POST /api/donations/record
GET /api/donations/campaign-total/{campaignId}

## Project structure
- src/main/java/com/wipro/ngo/entity - entities
- src/main/java/com/wipro/ngo/repository - repositories and SQL/JPA reports
- src/main/java/com/wipro/ngo/service - business logic
- src/main/java/com/wipro/ngo/controller - REST API
- src/main/java/com/wipro/ngo/dto - request/report DTOs
- src/main/resources/schema.sql - table creation
- src/main/resources/data.sql - sample records
- src/main/resources/static - frontend
- database/ngo_donation_management.sql - procedure, function and trigger

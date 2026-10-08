package com.wipro.ngo.repository;

import com.wipro.ngo.entity.Donation;
import com.wipro.ngo.dto.DonationJoinDTO;
import com.wipro.ngo.dto.AboveAverageDonorDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    // JOIN QUERY
    // Gets donation details with donor and campaign information
    @Query("""
        SELECT new com.wipro.ngo.dto.DonationJoinDTO(
            d.donationId,
            dr.donorName,
            dr.email,
            c.campaignName,
            d.amount,
            d.paymentMethod,
            d.donatedAt
        )
        FROM Donation d
        JOIN d.donor dr
        JOIN d.campaign c
        ORDER BY d.donatedAt DESC
        """)
    List<DonationJoinDTO> findDonationsWithDonorAndCampaign();


    // SUBQUERY
    // Finds donors whose total donation is greater
    // than the average donation amount
    @Query("""
        SELECT new com.wipro.ngo.dto.AboveAverageDonorDTO(
            dr.donorId,
            dr.donorName,
            dr.email,
            SUM(d.amount)
        )
        FROM Donation d
        JOIN d.donor dr
        GROUP BY dr.donorId, dr.donorName, dr.email
        HAVING SUM(d.amount) > (
            SELECT AVG(x.amount)
            FROM Donation x
        )
        """)
    List<AboveAverageDonorDTO> findDonorsAboveAverage();


    // MYSQL FUNCTION
    // Calls get_campaign_total() function
    @Query(
        value = "SELECT get_campaign_total(:campaignId)",
        nativeQuery = true
    )
    Double getCampaignTotal(@Param("campaignId") Long campaignId);
}
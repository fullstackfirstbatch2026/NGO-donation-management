
package com.wipro.ngo.service;

import com.wipro.ngo.entity.*;
import com.wipro.ngo.dto.*;
import com.wipro.ngo.repository.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.*;

@Service
public class DonationService {

    private final DonationRepository donationRepo;
    private final DonorRepository donorRepo;
    private final CampaignRepository campaignRepo;
    private final JdbcTemplate jdbc;

    public DonationService(
            DonationRepository d,
            DonorRepository dr,
            CampaignRepository cr,
            JdbcTemplate jdbc) {

        donationRepo = d;
        donorRepo = dr;
        campaignRepo = cr;
        this.jdbc = jdbc;
    }

    public List<Donation> all() {
        return donationRepo.findAll();
    }

    public List<DonationJoinDTO> joinReport() {
        return donationRepo.findDonationsWithDonorAndCampaign();
    }

    public List<AboveAverageDonorDTO> aboveAverage() {
        return donationRepo.findDonorsAboveAverage();
    }

    @Transactional
    public Donation save(DonationRequest r) {

        Donor donor = donorRepo.findById(r.getDonorId())
                .orElseThrow();

        Campaign campaign = campaignRepo.findById(r.getCampaignId())
                .orElseThrow();

        Donation d = new Donation();

        d.setDonor(donor);
        d.setCampaign(campaign);
        d.setAmount(r.getAmount());
        d.setPaymentMethod(r.getPaymentMethod());
        d.setNote(r.getNote());

        return donationRepo.save(d);
    }

    @Transactional
    public void recordUsingProcedure(DonationRequest r) {

        jdbc.update(
                "CALL record_donation(?,?,?,?)",
                r.getDonorId(),
                r.getCampaignId(),
                r.getAmount(),
                r.getPaymentMethod()
        );
    }

    public BigDecimal campaignTotal(Long campaignId) {

        return jdbc.queryForObject(
                "SELECT get_campaign_total(?)",
                BigDecimal.class,
                campaignId
        );
    }
}


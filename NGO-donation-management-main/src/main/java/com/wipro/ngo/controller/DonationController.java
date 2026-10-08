package com.wipro.ngo.controller;
import com.wipro.ngo.dto.*; import com.wipro.ngo.entity.Donation; import com.wipro.ngo.service.DonationService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*; import java.math.BigDecimal; import java.util.*;
@RestController @RequestMapping("/api/donations") @CrossOrigin
public class DonationController {
 private final DonationService s; public DonationController(DonationService s){this.s=s;}
 @GetMapping public List<Donation> all(){return s.all();}
 @GetMapping("/join-report") public List<DonationJoinDTO> join(){return s.joinReport();}
 @GetMapping("/above-average") public List<AboveAverageDonorDTO> aboveAverage(){return s.aboveAverage();}
 @PostMapping public Donation save(@Valid @RequestBody DonationRequest r){return s.save(r);}
 @PostMapping("/record") public Map<String,String> record(@Valid @RequestBody DonationRequest r){s.recordUsingProcedure(r);return Map.of("message","Donation recorded using stored procedure");}
 @GetMapping("/campaign-total/{campaignId}") public BigDecimal total(@PathVariable Long campaignId){return s.campaignTotal(campaignId);}
}
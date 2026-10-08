package com.wipro.ngo.dto;
import java.math.BigDecimal; import java.time.LocalDateTime;
public record DonationJoinDTO(Long donationId,String donorName,String donorEmail,String campaignName,BigDecimal amount,String paymentMethod,LocalDateTime donatedAt) {}
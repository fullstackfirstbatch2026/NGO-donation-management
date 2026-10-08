package com.wipro.ngo.dto;
import java.math.BigDecimal;
public record AboveAverageDonorDTO(Long donorId,String donorName,String email,BigDecimal totalDonation) {}
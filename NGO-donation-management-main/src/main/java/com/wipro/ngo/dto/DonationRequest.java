package com.wipro.ngo.dto;
import jakarta.validation.constraints.*; import java.math.BigDecimal;
public class DonationRequest {
 @NotNull private Long donorId; @NotNull private Long campaignId; @NotNull @Positive private BigDecimal amount;
 private String paymentMethod; private String note;
 public Long getDonorId(){return donorId;} public void setDonorId(Long v){donorId=v;}
 public Long getCampaignId(){return campaignId;} public void setCampaignId(Long v){campaignId=v;}
 public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;}
 public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;}
 public String getNote(){return note;} public void setNote(String v){note=v;}
}
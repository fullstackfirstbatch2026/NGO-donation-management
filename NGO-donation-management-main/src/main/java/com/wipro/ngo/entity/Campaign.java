package com.wipro.ngo.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="campaigns")
public class Campaign {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="campaign_id") private Long campaignId;
 @NotBlank @Column(name="campaign_name",nullable=false) private String campaignName;
 private String description;
 @Column(name="target_amount",precision=12,scale=2) @Positive private BigDecimal targetAmount;
 @Column(name="donation_amount",precision=12,scale=2,nullable=false) private BigDecimal donationAmount=BigDecimal.ZERO;
 @Column(name="start_date") private LocalDate startDate; @Column(name="end_date") private LocalDate endDate;
 public Long getCampaignId(){return campaignId;} public void setCampaignId(Long v){campaignId=v;}
 public String getCampaignName(){return campaignName;} public void setCampaignName(String v){campaignName=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public BigDecimal getTargetAmount(){return targetAmount;} public void setTargetAmount(BigDecimal v){targetAmount=v;}
 public BigDecimal getDonationAmount(){return donationAmount;} public void setDonationAmount(BigDecimal v){donationAmount=v;}
 public LocalDate getStartDate(){return startDate;} public void setStartDate(LocalDate v){startDate=v;}
 public LocalDate getEndDate(){return endDate;} public void setEndDate(LocalDate v){endDate=v;}
}
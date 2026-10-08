package com.wipro.ngo.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity @Table(name="donations")
public class Donation {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="donation_id") private Long donationId;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="donor_id",nullable=false) private Donor donor;
 @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="campaign_id",nullable=false) private Campaign campaign;
 @Positive @Column(nullable=false,precision=12,scale=2) private BigDecimal amount;
 @Column(name="payment_method") private String paymentMethod;
 private String note;
 @Column(name="donated_at") private LocalDateTime donatedAt;
 @PrePersist void created(){if(donatedAt==null) donatedAt=LocalDateTime.now();}
 public Long getDonationId(){return donationId;} public void setDonationId(Long v){donationId=v;}
 public Donor getDonor(){return donor;} public void setDonor(Donor v){donor=v;}
 public Campaign getCampaign(){return campaign;} public void setCampaign(Campaign v){campaign=v;}
 public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;}
 public String getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(String v){paymentMethod=v;}
 public String getNote(){return note;} public void setNote(String v){note=v;}
 public LocalDateTime getDonatedAt(){return donatedAt;} public void setDonatedAt(LocalDateTime v){donatedAt=v;}
}
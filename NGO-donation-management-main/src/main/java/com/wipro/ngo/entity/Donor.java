package com.wipro.ngo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;
@Entity @Table(name="donors")
public class Donor {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="donor_id") private Long donorId;
 @NotBlank @Column(name="donor_name",nullable=false) private String donorName;
 @Email @NotBlank @Column(nullable=false,unique=true) private String email;
 private String phone; private String address;
 @Column(name="created_at") private LocalDateTime createdAt;
 @PrePersist void created(){if(createdAt==null) createdAt=LocalDateTime.now();}
 public Long getDonorId(){return donorId;} public void setDonorId(Long v){donorId=v;}
 public String getDonorName(){return donorName;} public void setDonorName(String v){donorName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getAddress(){return address;} public void setAddress(String v){address=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public void setCreatedAt(LocalDateTime v){createdAt=v;}
}
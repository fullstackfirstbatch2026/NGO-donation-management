package com.wipro.ngo.entity;
import jakarta.persistence.*; import jakarta.validation.constraints.*;
@Entity @Table(name="volunteers")
public class Volunteer {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="volunteer_id") private Long volunteerId;
 @NotBlank @Column(name="volunteer_name",nullable=false) private String volunteerName;
 @Email @NotBlank private String email; private String phone; private String skills;
 public Long getVolunteerId(){return volunteerId;} public void setVolunteerId(Long v){volunteerId=v;}
 public String getVolunteerName(){return volunteerName;} public void setVolunteerName(String v){volunteerName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPhone(){return phone;} public void setPhone(String v){phone=v;}
 public String getSkills(){return skills;} public void setSkills(String v){skills=v;}
}
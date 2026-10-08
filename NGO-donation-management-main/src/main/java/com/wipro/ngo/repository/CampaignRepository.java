package com.wipro.ngo.repository;
import com.wipro.ngo.entity.Campaign;
 import org.springframework.data.jpa.repository.JpaRepository;
public interface CampaignRepository extends JpaRepository<Campaign,Long> {}
package com.wipro.ngo.service;
import com.wipro.ngo.entity.Campaign;
 import com.wipro.ngo.repository.CampaignRepository; 
 import org.springframework.stereotype.Service; 
 import java.util.*;
@Service public class CampaignService {
 private final CampaignRepository repo; 
 public CampaignService(CampaignRepository repo){this.repo=repo;}
 public List<Campaign> all(){return repo.findAll();} 
 public Campaign get(Long id){return repo.findById(id).orElseThrow();}
 public Campaign save(Campaign c){return repo.save(c);} 
 public void delete(Long id){repo.deleteById(id);}
}
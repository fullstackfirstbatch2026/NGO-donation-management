package com.wipro.ngo.controller;
import com.wipro.ngo.entity.Campaign; 
import com.wipro.ngo.service.CampaignService;
 import jakarta.validation.Valid;
  import org.springframework.web.bind.annotation.*;
   import java.util.*;
@RestController @RequestMapping("/api/campaigns") @CrossOrigin
public class CampaignController {private final CampaignService s;
    
    
    public CampaignController(CampaignService s){this.s=s;}
@GetMapping public List<Campaign> all(){return s.all();} @GetMapping("/{id}") public Campaign get(@PathVariable Long id){return s.get(id);}
@PostMapping public Campaign save(@Valid @RequestBody Campaign c){return s.save(c);}
 @DeleteMapping("/{id}") public void delete(@PathVariable Long id){s.delete(id);}}
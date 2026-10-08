package com.wipro.ngo.service;
import com.wipro.ngo.entity.Donor; 
import com.wipro.ngo.repository.DonorRepository; 
import org.springframework.stereotype.Service; import java.util.*;
@Service public class DonorService {
 private final DonorRepository repo; 
 public DonorService(DonorRepository repo){this.repo=repo;}
 public List<Donor> all(){return repo.findAll();}
  public Donor get(Long id){return repo.findById(id).orElseThrow();}
 public Donor save(Donor d){return repo.save(d);}
  public void delete(Long id){repo.deleteById(id);}
}
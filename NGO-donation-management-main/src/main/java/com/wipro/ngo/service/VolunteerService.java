package com.wipro.ngo.service;
import com.wipro.ngo.entity.Volunteer; import com.wipro.ngo.repository.VolunteerRepository; import org.springframework.stereotype.Service; import java.util.*;
@Service public class VolunteerService {
 private final VolunteerRepository repo; public VolunteerService(VolunteerRepository repo){this.repo=repo;}
 public List<Volunteer> all(){return repo.findAll();} public Volunteer save(Volunteer v){return repo.save(v);} public void delete(Long id){repo.deleteById(id);}
}
package com.wipro.ngo.controller;
import com.wipro.ngo.entity.Volunteer; import com.wipro.ngo.service.VolunteerService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/volunteers") @CrossOrigin
public class VolunteerController {private final VolunteerService s; public VolunteerController(VolunteerService s){this.s=s;}
@GetMapping public List<Volunteer> all(){return s.all();} @PostMapping public Volunteer save(@Valid @RequestBody Volunteer v){return s.save(v);} @DeleteMapping("/{id}") public void delete(@PathVariable Long id){s.delete(id);}}
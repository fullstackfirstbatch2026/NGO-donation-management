package com.wipro.ngo.controller;
import com.wipro.ngo.entity.Donor; import com.wipro.ngo.service.DonorService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/donors") @CrossOrigin
public class DonorController {private final DonorService s; public DonorController(DonorService s){this.s=s;}
@GetMapping public List<Donor> all(){return s.all();} @GetMapping("/{id}") public Donor get(@PathVariable Long id){return s.get(id);}
@PostMapping public Donor save(@Valid @RequestBody Donor d){return s.save(d);} @DeleteMapping("/{id}") public void delete(@PathVariable Long id){s.delete(id);}}
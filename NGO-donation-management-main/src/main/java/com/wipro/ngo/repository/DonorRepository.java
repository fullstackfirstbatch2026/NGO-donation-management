package com.wipro.ngo.repository;
import com.wipro.ngo.entity.Donor; import org.springframework.data.jpa.repository.JpaRepository;
public interface DonorRepository extends JpaRepository<Donor,Long> {}
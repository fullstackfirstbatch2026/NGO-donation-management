package com.wipro.ngo.repository;
import com.wipro.ngo.entity.Volunteer; import org.springframework.data.jpa.repository.JpaRepository;
public interface VolunteerRepository extends JpaRepository<Volunteer,Long> {}
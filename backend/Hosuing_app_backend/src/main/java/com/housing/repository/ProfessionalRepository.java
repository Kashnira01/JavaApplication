package com.housing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.housing.entity.Professional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

}

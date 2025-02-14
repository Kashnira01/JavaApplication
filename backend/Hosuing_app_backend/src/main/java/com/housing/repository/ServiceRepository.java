package com.housing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.housing.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}

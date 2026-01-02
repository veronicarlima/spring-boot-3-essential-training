package com.frankmoley.lil.roomwebapp.data.repository;

import com.frankmoley.lil.roomwebapp.data.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesEntity, UUID> {
}

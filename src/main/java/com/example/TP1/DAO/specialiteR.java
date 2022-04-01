package com.example.TP1.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.TP1.entities.specialites;

@RepositoryRestResource
public interface specialiteR  extends JpaRepository<specialites, Long >{

}
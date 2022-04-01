package com.example.TP1.DAO;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.TP1.entities.Departement;

@RepositoryRestResource
public interface DepartementR extends JpaRepository<Departement, Long> {

	@RestResource(path = "/allD")
	@Query("select d.nom_dept from Departement d ")
	Collection<Object> Afficher1();

}
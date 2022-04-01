package com.example.TP1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Departement {
	@Id
	@GeneratedValue
	private Long ID_department;
	private String nom_dept;
	
	
	
	public Long getID_department() {
		return ID_department;
	}
	public void setID_department(Long iD_department) {
		ID_department = iD_department;
	}
	public String getnom_dept() {
		return nom_dept;
	}
	public void setnom_dept(String nom_dept) {
		this.nom_dept = nom_dept;
	}
	

	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Departement(Long iD_department, String nom_dept) {
		super();
		ID_department = iD_department;
		this.nom_dept = nom_dept;
	}
	@Override
	public String toString() {
		return "Departement [ID_department=" + ID_department + ", nom_dept=" + nom_dept + "]";
	}
	
	
}

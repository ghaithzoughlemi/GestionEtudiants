package com.example.TP1.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class promotion {
	@Id
	@GeneratedValue
	private Long id_promotion;
	public Long getId_promotion() {
		return id_promotion;
	}
	public void setId_promotion(Long id_promotion) {
		this.id_promotion = id_promotion;
	}
	public String getNom_promotion() {
		return nom_promotion;
	}
	public void setNom_promotion(String nom_promotion) {
		this.nom_promotion = nom_promotion;
	}
	private String nom_promotion;
	
}

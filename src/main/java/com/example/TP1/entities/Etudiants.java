package com.example.TP1.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiants {
	@Id
	@GeneratedValue
	private Long IdE;
	private String nome;
	private int Niveau;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "datee")
	private LocalDateTime dateE;

	@ManyToOne
	@JoinColumn(name = "spec")
	private specialites st;

	@ManyToOne
	@JoinColumn(name = "dept")
	private Departement dt;

	private Double moyenne;
	private String imageEtudiant;



	public Etudiants(String nomE, int niveau, LocalDateTime dateE, specialites st, 
			Departement dt, Double moyenne, String imageEtudiant) {
		super();
		this.nome = nomE;
		this.Niveau = niveau;
		this.dateE = dateE;
		this.st = st;
		this.dt = dt;
		this.moyenne = moyenne;
		this.imageEtudiant = imageEtudiant;
	}

}

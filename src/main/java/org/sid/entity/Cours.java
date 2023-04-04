package org.sid.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Cours")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cours {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCours;
	private String label;
	private String duree;
	private String debut;
	String titre; 
	String description;
	private Long idType;
	private Long idEnseignant;
}
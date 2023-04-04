package org.sid.entityDto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CoursDto {
	
	
	private Integer idCours;
	private String label;
	private String duree;
	private String debut;
	String titre; 
	String description;
	
}

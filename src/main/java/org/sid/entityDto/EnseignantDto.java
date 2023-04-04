package org.sid.entityDto;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EnseignantDto {
	private Long id;
	private String nom;
	private String prenom;
    private String email;
    private String password ;
    private String grade ;
    private String spécialité;
	
}

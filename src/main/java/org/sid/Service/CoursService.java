package org.sid.Service;


import java.util.List;

import org.sid.entity.Cours;
import org.sid.entityDto.ResponseDto;


public interface CoursService {
	Cours ajouterCours(Cours cours);
	List<Cours>getAllCours();
	void supprimer_cours (Long coursId);
	
    ResponseDto getCours(Long coursId);
    
}

package org.sid.Service;

import java.util.List;


import org.sid.Repository.CoursRepository;

import org.sid.entity.Cours;
import org.sid.entityDto.CoursDto;
import org.sid.entityDto.EnseignantDto;
import org.sid.entityDto.ResponseDto;
import org.sid.entityDto.TypeContenuDTo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CoursImpService  implements CoursService{

	 private CoursRepository coursRepostory;
	 private RestTemplate restTemplate;
	@Override
	public Cours ajouterCours(Cours cours) {
		// TODO Auto-generated method stub
		return coursRepostory.save(cours);
	}

	@Override
	public List<Cours> getAllCours() {
		// TODO Auto-generated method stub
		return coursRepostory.findAll();
	}

	@Override
	public ResponseDto getCours(Long coursId) {
		// TODO Auto-generated method stub
		ResponseDto responseDto = new ResponseDto();
		Cours cours = coursRepostory.findById(coursId).get();
		CoursDto coursDto = mapToUser(cours);
		ResponseEntity<TypeContenuDTo> responseEntity = restTemplate
                .getForEntity("http://localhost:8041/api/TypeContenu/" + cours.getIdType(),
                TypeContenuDTo.class);
		ResponseEntity<EnseignantDto> responseEntity1 = restTemplate
                .getForEntity("http://localhost:8777/enseignant/" + cours.getIdEnseignant(),
                		EnseignantDto.class);
		TypeContenuDTo typecontenuDto = responseEntity.getBody();
		EnseignantDto enseignatDto = responseEntity1.getBody();
		 System.out.println(responseEntity.getStatusCode());
		 System.out.println(responseEntity1.getStatusCode());

	        responseDto.setCours(coursDto);
	        responseDto.setTypecontenu(typecontenuDto);
	        responseDto.setEnseignantDto(enseignatDto);
	        return responseDto;
		
		
	}

	private CoursDto mapToUser(Cours cours) {
		CoursDto coursDto = new CoursDto();
        coursDto.setIdCours(cours.getIdCours());
        coursDto.setDebut(cours.getDebut());
        coursDto.setDescription(cours.getDescription());
        coursDto.setDuree(cours.getDuree());
        coursDto.setLabel(cours.getLabel());
        coursDto.setTitre(cours.getTitre());
        
        
        return coursDto;
	}

	@Override
	public void supprimer_cours(Long coursId) {
		// TODO Auto-generated method stub
		this.coursRepostory.deleteById(coursId);
		
	}

	

	
	}



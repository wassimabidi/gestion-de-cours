package org.sid.Controller;


import java.util.List;

import org.sid.Service.CoursService;

import org.sid.entity.Cours;

import org.sid.entityDto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/cours")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class CoursController {
	private CoursService coursService;
	@PostMapping
    public ResponseEntity<Cours> saveCours(@RequestBody Cours cours){
        Cours savedCours = coursService.ajouterCours(cours);
        return new ResponseEntity<>(savedCours, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<ResponseDto> getCours(@PathVariable("id") Long coursId){
        ResponseDto responseDto = coursService.getCours(coursId);
        return ResponseEntity.ok(responseDto);
    }
    @GetMapping
    public List<Cours>getAllCours()
	{
	  return  coursService.getAllCours();
	}
	@DeleteMapping("{id}")
		void deletecours(@PathVariable Long id) {
			 coursService.supprimer_cours(id);
		}
    
   
}

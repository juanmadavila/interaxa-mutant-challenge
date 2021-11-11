package com.interaxa.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.interaxa.app.model.dto.PersonRequest;
import com.interaxa.app.model.dto.PersonResponse;
import com.interaxa.app.service.abstraction.IPersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
	
	@Autowired
	private IPersonService personService;
	
	@PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create (@Valid @RequestBody PersonRequest personRequest){
		personService.create(personRequest);
		return new ResponseEntity<>(personRequest, HttpStatus.CREATED);		
	}
	
	@DeleteMapping(value = "/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete (@PathVariable Long id){
		personService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);		
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody PersonRequest person, @PathVariable Long id){
		PersonResponse personResponse = personService.update(person, id);
		return new ResponseEntity<>(personResponse, HttpStatus.OK);
	}
	

}

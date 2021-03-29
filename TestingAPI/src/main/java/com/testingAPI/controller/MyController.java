package com.testingAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testingAPI.beans.Persons;
import com.testingAPI.service.PersonsServiceI;

@RestController
@CrossOrigin("*")
@RequestMapping("/persons")
public class MyController {

	@Autowired
	private PersonsServiceI service;

	@GetMapping("/getAllPersons")
	public ResponseEntity<List<Persons>> getAllPersonsDetails(){
		List<Persons> list = service.getAllPersons();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getPerson/{id}")
	public ResponseEntity<Persons> getPerson(@PathVariable("id") int id){
		Persons p = service.getPerson(id);
		if(p!=null)
			return new ResponseEntity<>(p,HttpStatus.OK);
		else
			return new ResponseEntity<>(p,HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/createPerson")
	public ResponseEntity<String> createPerson(@RequestBody Persons person){
		Persons p = service.createPerson(person);
		if(p!=null)
			return new ResponseEntity<>("person details were successfully created..!!", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("sorry, something went wrong..!!", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/updatePerson")
	public ResponseEntity<String> updatePerson(@RequestBody Persons person){
		Persons p = service.updatePerson(person);
		if(p!=null)
			return new ResponseEntity<>("person details were updated successfully..!!", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("sorry, something went wrong..!!", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/deletePerson/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable int id){
		Persons p = service.deletePerson(id);
		if(p!=null)
			return new ResponseEntity<>("person details were deleted successfully..!!", HttpStatus.OK);
		else
			return new ResponseEntity<>("sorry, something went wrong..!!", HttpStatus.BAD_REQUEST);
	}
}
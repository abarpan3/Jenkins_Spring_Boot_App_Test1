package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.lti.model.Login;
import com.lti.model.Person;
import com.lti.service.LoginServiceImpl;
import com.lti.service.PersonService;

@RestController
@CrossOrigin
@RequestMapping(path = "users")
public class PersonController {

	/*
	 * Transaction Types: 1. BMT (Bean Managed Transaction) / UMT (User Managed
	 * Transaction) 2. CMT (Container Managed Transaction)
	 * 
	 */

	@Autowired
	private PersonService service;

	@Autowired
	private LoginServiceImpl loginservice;

	// http://localhost:9091/UserMgmtApp/users/
	@GetMapping(path = "/")
	public List<Person> getAllPersons() {

		List<Person> persons = service.findAllPersons();
		return persons;
	}

	// http://localhost:9091/UserMgmtApp/users/10
	@GetMapping(path = "{personId}")
	public Person getPersonbyId(@PathVariable("personId") int personId) {

		return service.findPersonbyId(personId);
	}

	@PostMapping(path = "/")
	public void addPerson(@RequestBody Person person) {

		service.addPerson(person);
	}

	@DeleteMapping(path = "{personId}")
	public void deletePersonbyId(@PathVariable("personId") int personId) {

		service.removePerson(personId);
	}

	@PutMapping(path = "{personId}")
	public Person updatePerson(@RequestBody Person person) {

		boolean result = service.modifyPerson(person);
		if (result) {
			person = service.findPersonbyId(person.getId());
		}
		return person;
	}

	@PostMapping(path = "login")
	public ResponseEntity<Object> loginadmin(@RequestBody Login login) {

		boolean result = loginservice.verifyLogin(login);
		if (result) {
			return ResponseEntity.ok("Login Success");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}

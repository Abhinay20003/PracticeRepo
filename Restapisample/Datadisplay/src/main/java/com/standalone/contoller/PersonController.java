package com.standalone.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.standalone.model.Person;
import com.standalone.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping
	public List<Person> getAllPersons() {
		return personService.getAllPersons();
	}
}

package com.standalone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.standalone.model.Person;
import com.standalone.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}
}

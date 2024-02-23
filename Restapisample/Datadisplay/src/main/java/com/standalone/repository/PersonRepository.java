package com.standalone.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.standalone.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	
}
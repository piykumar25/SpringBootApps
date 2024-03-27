package com.coder.coderschool.repository;

import com.coder.coderschool.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {


    Person readByEmail(String email);

}

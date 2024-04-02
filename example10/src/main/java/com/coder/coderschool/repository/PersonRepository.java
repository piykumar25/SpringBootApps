package com.coder.coderschool.repository;

import com.coder.coderschool.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface PersonRepository extends CrudRepository<Person, Integer> {


    Person readByEmail(String email);

}

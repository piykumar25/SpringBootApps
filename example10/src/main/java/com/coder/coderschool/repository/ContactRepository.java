package com.coder.coderschool.repository;

import com.coder.coderschool.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {


    List<Contact> findByStatus(String status);

}

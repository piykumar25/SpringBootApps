package com.coder.coderschool.service;

import com.coder.coderschool.constants.CoderSchoolConstants;
import com.coder.coderschool.model.Person;
import com.coder.coderschool.model.Roles;
import com.coder.coderschool.repository.PersonRepository;
import com.coder.coderschool.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = roleRepository.getByRoleName(CoderSchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person.setPwd(passwordEncoder.encode(person.getPwd()));
        person = personRepository.save(person);
        if(null != person && person.getPersonId() > 0) {
            isSaved = true;
        }
        return isSaved;

    }
}

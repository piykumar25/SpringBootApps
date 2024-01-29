package com.coder.coderschool.service;

import com.coder.coderschool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@Service
@RequestScope
public class ContactService {

//    private static final Logger log = LoggerFactory.getLogger(ContactService.class);
    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */

    private int counter = 0;
    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        //TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

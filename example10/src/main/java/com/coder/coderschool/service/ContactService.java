package com.coder.coderschool.service;

import com.coder.coderschool.constants.CoderSchoolConstants;
import com.coder.coderschool.model.Contact;
import com.coder.coderschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
//@RequestScope
//@SessionScope
@ApplicationScope
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }
    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        contact.setStatus(CoderSchoolConstants.OPEN);
        Contact saveContact = contactRepository.save(contact);
        if (saveContact.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus() {
        List<Contact> contactMsgs = contactRepository.findByStatus(CoderSchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId) {
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
                    contact1.setStatus(CoderSchoolConstants.CLOSE);
                }
        );
        Contact updateContact = contactRepository.save(contact.get());
        if (updateContact.getUpdatedBy() != null){
            isUpdated = true;
        }
        return isUpdated;
    }

}

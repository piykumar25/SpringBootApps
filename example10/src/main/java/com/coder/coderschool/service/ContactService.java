package com.coder.coderschool.service;

import com.coder.coderschool.constants.CoderSchoolConstants;
import com.coder.coderschool.model.Contact;
import com.coder.coderschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatus(
                CoderSchoolConstants.OPEN, pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId) {
        boolean isUpdated = false;
        int rows = contactRepository.updateMsgStatus(CoderSchoolConstants.CLOSE, contactId);
        if (rows > 0 ){
            isUpdated = true;
        }
        return isUpdated;
    }

    public List<Contact> getAllMessages(String status) {
        return contactRepository.findByStatus(status);

    }

}

package com.coder.coderschool.rest;

import com.coder.coderschool.constants.CoderSchoolConstants;
import com.coder.coderschool.model.Contact;
import com.coder.coderschool.model.Response;
import com.coder.coderschool.repository.ContactRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController //--> @Controller + @ResponseBody
@RequestMapping(path = "/api/contact", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
@CrossOrigin(origins = "*")
public class ContactRestController {

    @Autowired
    ContactRepository contactRepository;

    @GetMapping("/getMessageByStatus")
    public List<Contact> getMessageByStatus(@RequestParam(name = "status") String status) {
        return contactRepository.findByStatus(status);

    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> saveMsg(@RequestHeader("invoactionFrom") String invocationFrom,
                                            @Valid @RequestBody Contact contact) {
        log.info(String.format("Header invocationFrom: %s", invocationFrom));
        contactRepository.save(contact);
        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMsg("Message saved successfully");
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("isMsgSaved", "true")
                .body(response);
    }

    @DeleteMapping("/deleteMsg")
    public ResponseEntity<Response> deleteMsg(RequestEntity<Contact> requestEntity) {
        HttpHeaders headers = requestEntity.getHeaders();
        headers.forEach((k, v) -> {
            log.info(String.format(
                    "Header %s =  %s", k, v.stream().collect(Collectors.joining("|"))));

        });
        Contact contact = requestEntity.getBody();
        contactRepository.deleteById(contact.getContactId());
        Response response = new Response();
        response.setStatusCode("200");
        response.setStatusMsg("Message deleted successfully");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @PatchMapping("/closeMsg")
    public ResponseEntity<Response> closeMsg(@RequestBody Contact contactReq) {
        Response response = new Response();
        Optional<Contact> contact = contactRepository.findById(contactReq.getContactId());
        if(contact.isPresent()) {
            contact.get().setStatus(CoderSchoolConstants.CLOSE);
           contactRepository.save(contact.get());
        } else {
            response.setStatusCode("404");
            response.setStatusMsg("Invalid Contact Id received");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(response);
        }
        response.setStatusCode("200");
        response.setStatusMsg("Message closed successfully");
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }
}

package com.coderSchool.example11.proxy;

import com.coderSchool.example11.config.ProjectConfiguration;
import com.coderSchool.example11.model.Contact;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "contact", url = "http://localhost:8080/api/contact",
configuration = ProjectConfiguration.class)
public interface ContactProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/getMessageByStatus")
    @Headers(value = "Content-Type: application/json")
    public List<Contact> getMessageByStatus(@RequestParam("status") String status);
}

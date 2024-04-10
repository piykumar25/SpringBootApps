package com.coder.coderschool.controller;

import com.coder.coderschool.model.Person;
import com.coder.coderschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/dashboard")
    public String displayDashboard(Model model, Authentication authentication, HttpSession session) {
        Person person = personRepository.readByEmail(authentication.getName());
        model.addAttribute("username", person.getName());
        model.addAttribute("roles", authentication.getAuthorities().toString());
        if(null != person.getCoderClass() && null != person.getCoderClass().getName()) {
            model.addAttribute("enrolledClass", person.getCoderClass().getName());
        }
        session.setAttribute("loggedInPerson", person);
        logMessage();
        return "dashboard.html";
    }

    private void logMessage() {
        log.error("Error message from the Dashboard Page");
        log.warn("Warning message from the Dashboard Page");
        log.info("Info message from the Dashboard Page");
        log.debug("Debug message from the Dashboard Page");
        log.trace("Trace message from the Dashboard Page");
    }
}


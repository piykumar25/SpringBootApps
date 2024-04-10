package com.coder.coderschool.controller;

import com.coder.coderschool.model.Person;
import com.coder.coderschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class DashboardController {

    @Value("${coderschool.pageSize}")
    private int defaultPageSize;

    @Value("${coderschool.contact.successMsg}")
    private String message;

    @Autowired
    private Environment environment;

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

        log.error("defaultPageSize value with @Value annotation is : " + defaultPageSize);
        log.error("SuccessMsg value with @Value annotation is : " + message);

        log.error("defaultPageSize value with Environment is : " + environment.getProperty("coderschool.pageSize"));
        log.error("SuccessMsg value with Environment is : " + environment.getProperty("coderschool.contact.successMsg"));
        log.error("Java Home environment variable using Environment is : " + environment.getProperty("JAVA_HOME"));


    }
}


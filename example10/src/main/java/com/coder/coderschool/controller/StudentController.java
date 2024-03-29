package com.coder.coderschool.controller;

import com.coder.coderschool.model.Person;
import com.coder.coderschool.repository.CoderClassRepository;
import com.coder.coderschool.repository.CoursesRepository;
import com.coder.coderschool.repository.PersonRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    CoderClassRepository coderClassRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CoursesRepository coursesRepository;

    @GetMapping("/displayCourses")
    public ModelAndView displayCourses(Model model, HttpSession session){
        Person person = (Person) session.getAttribute("loggedInPerson");
        ModelAndView modelAndView = new ModelAndView("courses_enrolled.html");
        modelAndView.addObject("person", person);
        return modelAndView;
    }

}

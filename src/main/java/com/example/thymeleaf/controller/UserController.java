package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Course;
import com.example.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/demo")
    public  String demo(Model model){
        double grade = 70.5;
        model.addAttribute("grade", grade);
        model.addAttribute("GPA", convertGPA(grade));
        model.addAttribute("message", "Hello Thymeleaf");
        model.addAttribute("courses", courses());
        return "demo";
    }

    public List<Course> courses(){
        List<Course> courses = List.of(
                new Course("Maths"),
                new Course("English"),
                new Course("Software Design"),
                new Course("Physics"),
                new Course("Sedimentology")
        );
        return courses;
    }

    private String convertGPA(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade < 90 && grade >= 80) {
            return "B";
        } else if (grade < 80 && grade >= 70) {
            return "C";
        } else if (grade < 70 && grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    @RequestMapping("/demo2")
    public String demo2(Model model){
        List<User> usersList = List.of(
                new User(1, "Oscar", 26),
                new User(2, "James", 30),
                new User(3, "Tobi", 24)
        );
        model.addAttribute("users", usersList);
        return "demo2";
    }

    @RequestMapping("/demo3")
    public String demo3(HttpServletRequest request, Model model){
        //Thymeleaf scope
        //request

        request.setAttribute("request", "request_data");
        //session
        request.getSession().setAttribute("session", "session data");
        request.getSession().getServletContext().setAttribute("application", "application data");
        return "demo2";
    }
}

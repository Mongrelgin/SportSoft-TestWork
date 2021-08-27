package com.example.sportsofttestwork.controller;

import com.example.sportsofttestwork.entity.User;
import com.example.sportsofttestwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginScreenController {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String homePage(HttpServletRequest request){
        request.setAttribute("mode", "MODE_HOME");
        return "loginscreen";
    }

    @RequestMapping("/registration")
    public String registration(HttpServletRequest request) {
        request.setAttribute("mode", "MODE_REGISTER");
        return "loginscreen";
    }

    @PostMapping("/save-user")
    public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
        service.saveUser(user);
        request.setAttribute("mode", "MODE_HOME");
        return "loginscreen";
    }

    @RequestMapping ("/login")
    public String login(@ModelAttribute User user, HttpServletRequest request) {
        if(service.findByLoginAndPass(user.getLogin(), user.getPass())!=null) {
            return "mainscreen";
        }
        else {
            request.setAttribute("error", "Invalid Username or Password");
            request.setAttribute("mode", "MODE_LOGIN");
            return "loginscreen";

        }
    }
}

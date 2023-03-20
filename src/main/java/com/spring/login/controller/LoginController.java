package com.spring.login.controller;

import com.spring.login.model.User;
import com.spring.login.service.user.v1.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/createUser")
    public String createuser(@ModelAttribute User user, HttpSession session) {

        if (userService.checkEmail(user.getEmail())) {
            session.setAttribute("msg", "Email Id alreday exists");
        } else {
            try{
                userService.createUser(user);
                session.setAttribute("msg", "Register Sucessfully");
            } catch (Exception e) {
                log.error(e.getMessage());
                session.setAttribute("msg", "Something wrong on server");
            }
        }

        return "redirect:/register";
    }
}

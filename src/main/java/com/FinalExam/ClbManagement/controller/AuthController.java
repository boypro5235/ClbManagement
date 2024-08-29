package com.FinalExam.ClbManagement.controller;

import com.FinalExam.ClbManagement.dto.request.LoginRequest;
import com.FinalExam.ClbManagement.entity.tblUser;
import com.FinalExam.ClbManagement.service.tblUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private tblUserService userService;

    @PostMapping("/login")
    public tblUser login(@RequestBody LoginRequest loginRequest) throws Exception {
        return userService.login(loginRequest.getUserName(), loginRequest.getPassword());
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "You have successfully logged out!";
    }
}

package com.FinalExam.ClbManagement.controller;

import com.FinalExam.ClbManagement.dto.request.RegisterRequest;
import com.FinalExam.ClbManagement.dto.request.tblUserCreationRequest;
import com.FinalExam.ClbManagement.dto.request.tblUserUpdateRequest;
import com.FinalExam.ClbManagement.entity.tblUser;
import com.FinalExam.ClbManagement.service.tblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class tblUserController {
    @Autowired
    private tblUserService tbluserService;

    @PostMapping
    public tblUser createUser(@RequestBody tblUserCreationRequest request){
        return tbluserService.createUser(request);
    }

    @PostMapping("/register")
    public tblUser registerUser(@RequestBody RegisterRequest request){
        return tbluserService.registerUser(request);
    }

    @GetMapping
    public List<tblUser> getUsers(){
        return tbluserService.getUsers();
    }

    @GetMapping("/id/{userId}")
    public tblUser getUser(@PathVariable("userId") int userId){
        return tbluserService.getUser(userId);
    }

    @PutMapping("/{userId}")
    public tblUser updateUser(@RequestBody tblUserUpdateRequest request, @PathVariable("userId") int userId){
        return tbluserService.updateUser(userId, request);
    }

    @DeleteMapping ("/{userId}")
    public void deleteUser(@PathVariable("userId") int userId){
        tbluserService.deleteUser(userId);
    }

    @GetMapping("/name/{userName}")
    public tblUser getUserbyName(@PathVariable("userName") String userName) {
        return tbluserService.getUserbyUserName(userName.toLowerCase());
    }
}

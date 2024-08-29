package com.FinalExam.ClbManagement.controller;

import com.FinalExam.ClbManagement.dto.UserClubDetailsDTO;
import com.FinalExam.ClbManagement.entity.UserClub;
import com.FinalExam.ClbManagement.service.UserClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/UserClub")
@RestController
public class UserClubController {
    @Autowired
    private UserClubService userClubService;

    @GetMapping("/user/{userId}")
    public List<UserClubDetailsDTO> getClubsByUserId(@PathVariable int userId) {
        return userClubService.getClubsByUserId(userId);
    }

    // API để lấy danh sách thành viên của một CLB
    @GetMapping("/club/{clubId}")
    public List<UserClubDetailsDTO> getMembersByClubId(@PathVariable int clubId) {
        return userClubService.getMembersByClubId(clubId);
    }

    @GetMapping("/club/count/{clubId}")
    public long countClubUser(@PathVariable int clubId){
        return userClubService.getMemberCount(clubId);
    }

}

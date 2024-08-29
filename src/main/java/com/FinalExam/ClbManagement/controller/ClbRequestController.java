package com.FinalExam.ClbManagement.controller;

import com.FinalExam.ClbManagement.dto.UserClubRequestDTO;
import com.FinalExam.ClbManagement.dto.request.ClbRequest;
import com.FinalExam.ClbManagement.entity.clb_request;
import com.FinalExam.ClbManagement.service.ClbRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club-requests")
public class ClbRequestController {

    @Autowired
    private ClbRequestService clbRequestService;

    // Tạo mới một yêu cầu tham gia câu lạc bộ
    @PostMapping("/create")
    public clb_request createRequest(@RequestBody ClbRequest request) {
        return clbRequestService.createRequest(request);
    }

    // Từ chối yêu cầu tham gia câu lạc bộ
    @PostMapping("/reject")
    public clb_request rejectRequest(@RequestBody ClbRequest request) {
        return clbRequestService.rejectRequest(request);
    }

    // Chấp nhận yêu cầu tham gia câu lạc bộ
    @PostMapping("/approve")
    public clb_request approveRequest(@RequestBody ClbRequest request) {
        return clbRequestService.approveRequest(request);
    }

    // Lấy danh sách các yêu cầu "Pending" của một câu lạc bộ
    @GetMapping("/pending/{clubId}")
    public List<UserClubRequestDTO> getPendingRequestsByClubId(@PathVariable int clubId) {
        return clbRequestService.getPendingRequestsByClubId(clubId);
    }

    //lấy danh sách các yêu cầu tham gia clb của 1 người dùng
    @GetMapping("/pending/user/{userId}")
    public List<UserClubRequestDTO> getPendingRequestsByUserId(@PathVariable int userId){
        return clbRequestService.getPendingRequestsByUserId(userId);
    }

    @DeleteMapping("/remove/{clubId}/{userId}")
    public String removeUserFromClub(@PathVariable int clubId, @PathVariable int userId) {
        clbRequestService.removeUserFromClub(userId, clubId);
        return "Member removed successfully";
    }
}


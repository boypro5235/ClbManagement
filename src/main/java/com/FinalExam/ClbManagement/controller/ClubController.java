package com.FinalExam.ClbManagement.controller;

import com.FinalExam.ClbManagement.dto.request.ClubRequest;
import com.FinalExam.ClbManagement.entity.Club;
import com.FinalExam.ClbManagement.entity.tblUser;
import com.FinalExam.ClbManagement.service.ClubService;
import com.FinalExam.ClbManagement.service.tblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Club")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping
    public List<Club> getClubById() {
        return clubService.getClubs();
    }

    @GetMapping("/{id}")
    public Club getClubById(@PathVariable int id) {
        return clubService.getClub(id);
    }

    @GetMapping("/imgBase64/{ClubId}")
    public String getImgBase64(@PathVariable int ClubId){
        return clubService.getClubImageBase64(ClubId);
    }

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @DeleteMapping("/{clubId}")
    public ResponseEntity<Void> deleteClub(@PathVariable int clubId) {
        clubService.deleteClub(clubId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Club> createOrUpdateClub(@RequestBody ClubRequest club) {
        Club savedClub = clubService.saveClub(club);
        return ResponseEntity.ok(savedClub);
    }

    @PutMapping("/update/{clbId}")
    public ResponseEntity<String> updateClub(@PathVariable int clbId, @RequestBody Club updatedClub) {
        try {
            boolean isUpdated = clubService.updateClub(clbId, updatedClub);
            if (isUpdated) {
                return ResponseEntity.ok("Club updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Club not found with ID: " + clbId);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}

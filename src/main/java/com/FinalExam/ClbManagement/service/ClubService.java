package com.FinalExam.ClbManagement.service;

import com.FinalExam.ClbManagement.dto.request.ClbRequest;
import com.FinalExam.ClbManagement.dto.request.ClubRequest;
import com.FinalExam.ClbManagement.entity.Club;
import com.FinalExam.ClbManagement.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public List<Club> getClubs(){
        return clubRepository.findAll();
    }

    public Club getClub(int id){
        return clubRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

    public Club saveImage(MultipartFile file) throws IOException {
        Club club = new Club();
        club.setImageData(file.getBytes());
        return clubRepository.save(club);
    }

    public String getClubImageBase64(int clbId) {
        Club club = clubRepository.findById(clbId).orElseThrow(() -> new RuntimeException("Club not found"));
        byte[] imageData = club.getImageData();

        // Chuyển đổi byte[] thành chuỗi base64
        return Base64.getEncoder().encodeToString(imageData);
    }


//    update
    public ClubService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    public boolean updateClub(int clbId, Club updatedClub) {
        Optional<Club> optionalClub = clubRepository.findById(clbId);

        if (optionalClub.isPresent()) {
            Club existingClub = optionalClub.get();
            // Cập nhật thông tin từ updatedClub
            existingClub.setClbName(updatedClub.getClbName());
            existingClub.setDescription(updatedClub.getDescription());
            existingClub.setDoe(updatedClub.getDoe());
            existingClub.setClbManagement(updatedClub.getClbManagement());
            existingClub.setImageData(updatedClub.getImageData());

            // Lưu lại thay đổi
            clubRepository.save(existingClub);
            return true;
        } else {
            return false;
        }
    }

    // Create or Update Club
    public Club saveClub(ClubRequest request) {
        Club club = new Club();

        // Chuyển dữ liệu từ ClubRequest sang Club
        club.setClbName(request.getClbName());
        club.setDescription(request.getDescription());
        club.setDoe(request.getDoe());
        club.setClbManagement(request.getClb_Management());
        club.setImageData(request.getImageData());

        // Lưu đối tượng Club vào cơ sở dữ liệu
        return clubRepository.save(club);
    }

    // Delete Club by ID
    public void deleteClub(int id) {
        clubRepository.deleteById(id);
    }
}

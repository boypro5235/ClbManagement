package com.FinalExam.ClbManagement.service;

import com.FinalExam.ClbManagement.dto.UserClubDetailsDTO;
import com.FinalExam.ClbManagement.dto.request.ClbRequest;
import com.FinalExam.ClbManagement.entity.Club;
import com.FinalExam.ClbManagement.entity.UserClub;
import com.FinalExam.ClbManagement.entity.tblUser;
import com.FinalExam.ClbManagement.repository.ClubRepository;
import com.FinalExam.ClbManagement.repository.UserClubRepository;
import com.FinalExam.ClbManagement.repository.tblUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserClubService {
    @Autowired
    private UserClubRepository userClubRepository;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private tblUserRepository userRepository;

    // Lấy danh sách CLB với thông tin chi tiết của user và club mà sinh viên tham gia
    public List<UserClubDetailsDTO> getClubsByUserId(int userId) {
        List<UserClub> userClubs = userClubRepository.findByUserId(userId);
        List<UserClubDetailsDTO> userClubDetailsList = new ArrayList<>();

        for (UserClub userClub : userClubs) {
            tblUser user = userRepository.findById(userClub.getUserId()).orElse(null);
            Club club = clubRepository.findById(userClub.getClubId()).orElse(null);

            if (user != null && club != null) {
                UserClubDetailsDTO detailsDTO = new UserClubDetailsDTO(
                        user.getUserId(),
                        user.getUserName(),
                        user.getName(),
                        club.getClbName(),
                        club.getDescription()
                );
                userClubDetailsList.add(detailsDTO);
            }
        }
        return userClubDetailsList;
    }

    // Lấy danh sách thành viên với thông tin chi tiết trong CLB
    public List<UserClubDetailsDTO> getMembersByClubId(int clubId) {
        List<UserClub> userClubs = userClubRepository.findByClubId(clubId);
        List<UserClubDetailsDTO> memberDetailsList = new ArrayList<>();

        for (UserClub userClub : userClubs) {
            tblUser user = userRepository.findById(userClub.getUserId()).orElse(null);
            Club club = clubRepository.findById(userClub.getClubId()).orElse(null);

            if (user != null && club != null) {
                UserClubDetailsDTO detailsDTO = new UserClubDetailsDTO(
                        user.getUserId(),
                        user.getUserName(),
                        user.getName(),
                        club.getClbName(),
                        club.getDescription()
                );
                memberDetailsList.add(detailsDTO);
            }
        }
        return memberDetailsList;
    }

    public long getMemberCount(int clubId) {
        return userClubRepository.countByClubId(clubId);
    }

    public void addUserToClub(ClbRequest request) {
        tblUser user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Club club = clubRepository.findById(request.getClubId()).orElseThrow(() -> new RuntimeException("Club not found"));

        UserClub userClub = new UserClub();
        userClub.setUserId(user.getUserId());
        userClub.setClubId(club.getClbId());

        userClubRepository.save(userClub);
    }
}

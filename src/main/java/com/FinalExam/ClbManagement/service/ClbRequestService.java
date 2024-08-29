package com.FinalExam.ClbManagement.service;

import com.FinalExam.ClbManagement.dto.UserClubRequestDTO;
import com.FinalExam.ClbManagement.dto.request.ClbRequest;
import com.FinalExam.ClbManagement.entity.*;
import com.FinalExam.ClbManagement.repository.ClbRequestRepository;
import com.FinalExam.ClbManagement.repository.UserClubRepository;
import com.FinalExam.ClbManagement.repository.tblUserRepository;
import com.FinalExam.ClbManagement.repository.ClubRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClbRequestService {
    @Autowired
    private ClbRequestRepository clbRequestRepository;

    @Autowired
    private UserClubService userClubService;

    @Autowired
    private UserClubRepository userClubRepository;

    @Autowired
    private tblUserRepository tbluserRepository;

    @Autowired
    private ClubRepository clubRepository;

    public clb_request createRequest(ClbRequest request){
        clb_request clbRequest = new clb_request();

        clbRequest.setClubId(request.getClubId());
        clbRequest.setUserId((request.getUserId()));
        clbRequest.setStatus("Pending");

        return clbRequestRepository.save(clbRequest);
    }

    public clb_request rejectRequest(ClbRequest request){
        Optional<clb_request> existingRequest = clbRequestRepository.findById(new UserClubId(request.getUserId(), request.getClubId()));

        if (existingRequest.isPresent()) {
            clb_request clbRequest = existingRequest.get();

            clbRequest.setStatus("Rejected");

            return clbRequestRepository.save(clbRequest);
        } else {

            throw new RuntimeException("Request not found.");
        }
    }

    public clb_request approveRequest(ClbRequest request){
        Optional<clb_request> existingRequest = clbRequestRepository.findById(new UserClubId(request.getUserId(), request.getClubId()));

        if (existingRequest.isPresent()) {
            clb_request clbRequest = existingRequest.get();

            clbRequest.setStatus("Approved");
            userClubService.addUserToClub(request);

            return clbRequestRepository.save(clbRequest);
        } else {

            throw new RuntimeException("Request not found.");
        }
    }

    public List<UserClubRequestDTO> getPendingRequestsByClubId(int clubId) {
        // Lấy tất cả các yêu cầu của câu lạc bộ
        List<clb_request> requests = clbRequestRepository.findByClubId(clubId);

        // Chuyển đổi các yêu cầu có trạng thái "Pending" thành DTO
        List<UserClubRequestDTO> pendingRequests = requests.stream()
                .filter(request -> "Pending".equals(request.getStatus()))
                .map(request -> {
                    // Tìm người dùng dựa trên userId, xử lý trường hợp Optional
                    Optional<tblUser> optionalUser = tbluserRepository.findById(request.getUserId());
                    UserClubRequestDTO dto = new UserClubRequestDTO();

                    // Set dữ liệu cho DTO
                    dto.setUserId(request.getUserId());
                    dto.setClubId(request.getClubId());
                    dto.setStatus(request.getStatus());

                    // Kiểm tra nếu user tồn tại
                    if (optionalUser.isPresent()) {
                        tblUser user = optionalUser.get();
                        dto.setUserName(user.getUserName());
                    } else {
                        dto.setUserName("Unknown"); // Nếu không tìm thấy người dùng
                    }

                    return dto;
                })
                .collect(Collectors.toList());

        return pendingRequests;
    }



    public List<UserClubRequestDTO> getPendingRequestsByUserId(int userId) {
        // Lấy tất cả các yêu cầu của người dùng
        List<clb_request> requests = clbRequestRepository.findByUserId(userId);

        // Chuyển đổi các yêu cầu thành DTO
        List<UserClubRequestDTO> pendingRequests = requests.stream()
                .map(request -> {
                    // Tìm câu lạc bộ dựa trên clubId, xử lý trường hợp Optional
                    Optional<Club> optClub = clubRepository.findById(request.getClubId());
                    UserClubRequestDTO dto = new UserClubRequestDTO();

                    // Set dữ liệu cho DTO
                    if (optClub.isPresent()) {
                        Club club = optClub.get();
                        dto.setClub(club.getClbName());  // Giả sử bạn có thuộc tính tên câu lạc bộ
                    } else {
                        dto.setClub("Unknown Club");  // Nếu không tìm thấy câu lạc bộ
                    }

                    dto.setUserId(request.getUserId());
                    dto.setClubId(request.getClubId());
                    dto.setStatus(request.getStatus());

                    return dto;
                })
                .collect(Collectors.toList());

        return pendingRequests;
    }



    public void removeUserFromClub(int userId, int clubId) {
        UserClubId userClubId = new UserClubId();

        userClubId.setClubId(clubId);
        userClubId.setUserId(userId);
        userClubRepository.deleteById(userClubId);
    }
}

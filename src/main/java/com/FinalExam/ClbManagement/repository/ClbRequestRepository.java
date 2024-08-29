package com.FinalExam.ClbManagement.repository;

import com.FinalExam.ClbManagement.entity.UserClub;
import com.FinalExam.ClbManagement.entity.clb_request;
import com.FinalExam.ClbManagement.entity.UserClubId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClbRequestRepository extends JpaRepository<clb_request, UserClubId> {
    List<clb_request> findByUserId(int userId);  // Tìm tất cả CLB mà sinh viên tham gia
    List<clb_request> findByClubId(int clubId);
}
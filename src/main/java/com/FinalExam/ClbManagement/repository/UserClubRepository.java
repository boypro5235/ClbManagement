package com.FinalExam.ClbManagement.repository;

import com.FinalExam.ClbManagement.entity.UserClub;
import com.FinalExam.ClbManagement.entity.UserClubId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserClubRepository extends JpaRepository<UserClub, UserClubId> {
    List<UserClub> findByUserId(int userId);  // Tìm tất cả CLB mà sinh viên tham gia
    List<UserClub> findByClubId(int clubId);  // Tìm tất cả thành viên của một CL
    long countByClubId(int clubId);
}

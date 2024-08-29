package com.FinalExam.ClbManagement.repository;

import com.FinalExam.ClbManagement.entity.tblUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface tblUserRepository extends JpaRepository<tblUser, Integer> {
    Optional<tblUser> findByuserName(String UserName);
}

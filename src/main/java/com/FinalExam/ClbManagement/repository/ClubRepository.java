package com.FinalExam.ClbManagement.repository;

import com.FinalExam.ClbManagement.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club, Integer> {

}

package com.FinalExam.ClbManagement.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserClub")
@IdClass(UserClubId.class)
public class UserClub {
    @Id
    @Column(name = "userId")
    private int userId;

    @Id
    @Column(name = "clubId")
    private int clubId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }
}

package com.FinalExam.ClbManagement.entity;

import jakarta.persistence.*;

@Entity
@Table(name="ClbRequest")
@IdClass(UserClubId.class)
public class clb_request{
    @Id
    @Column(name = "userId")
    private int userId;

    @Id
    @Column(name = "clubId")
    private int clubId;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

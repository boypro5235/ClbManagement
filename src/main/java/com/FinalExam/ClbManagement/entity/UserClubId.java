package com.FinalExam.ClbManagement.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserClubId implements Serializable {
    private int userId;
    private int clubId;

    // Constructors, Getters, Setters, equals(), hashCode()

    public UserClubId() {}

    public UserClubId(int userId, int clubId) {
        this.userId = userId;
        this.clubId = clubId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserClubId that = (UserClubId) o;
        return userId == that.userId && clubId == that.clubId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, clubId);
    }
}

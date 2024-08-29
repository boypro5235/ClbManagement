package com.FinalExam.ClbManagement.dto;

public class UserClubDetailsDTO {
    private int userId;
    private String userName;
    private String name;
    private String clubName;
    private String clubDescription;

    public UserClubDetailsDTO(int userId, String userName, String name, String clubName, String clubDescription) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubDescription() {
        return clubDescription;
    }

    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }
}

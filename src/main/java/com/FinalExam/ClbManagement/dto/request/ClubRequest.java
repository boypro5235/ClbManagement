package com.FinalExam.ClbManagement.dto.request;

import jakarta.persistence.Lob;

import java.sql.Date;

public class ClubRequest {
    private String ClbName;
    private String Description;
    private Date Doe;
    private int Clb_Management;
    @Lob
    private byte[] imageData;

    public String getClbName() {
        return ClbName;
    }

    public void setClbName(String clbName) {
        ClbName = clbName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Date getDoe() {
        return Doe;
    }

    public void setDoe(Date doe) {
        Doe = doe;
    }

    public int getClb_Management() {
        return Clb_Management;
    }

    public void setClb_Management(int clb_Management) {
        Clb_Management = clb_Management;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}

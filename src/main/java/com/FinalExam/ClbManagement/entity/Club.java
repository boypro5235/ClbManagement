package com.FinalExam.ClbManagement.entity;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.util.Base64;

@Entity
@RequestMapping("/Club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ClbId;
    private String ClbName;
    private String Description;
    private Date Doe;
    private int Clb_Management;
    @Lob
    private byte[] imageData;


    public int getClbId() {
        return ClbId;
    }

    public void setClbId(int clbId) {
        ClbId = clbId;
    }

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

    public int getClbManagement() {
        return Clb_Management;
    }

    public void setClbManagement(int clbManagement) {
        Clb_Management = clbManagement;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

}

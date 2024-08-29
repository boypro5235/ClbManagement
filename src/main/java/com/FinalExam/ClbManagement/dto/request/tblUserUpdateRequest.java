package com.FinalExam.ClbManagement.dto.request;

import java.sql.Date;

public class tblUserUpdateRequest {
    private String Password;
    private String Name;
    private Date dob;

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}

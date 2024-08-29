    package com.FinalExam.ClbManagement.entity;

    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;

    import java.sql.Date;

    @Entity
    public class tblUser {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int UserId;
        private String userName;
        private String Password;
        private String Name;
        private Date dob;
        private String role;
        //getter and setter
        public int getUserId() {
            return UserId;
        }

        public void setUserId(int userId) {
            UserId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String UserName) {
            userName = UserName;
        }

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

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }

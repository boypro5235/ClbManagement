package com.FinalExam.ClbManagement.service;

import com.FinalExam.ClbManagement.dto.request.RegisterRequest;
import com.FinalExam.ClbManagement.dto.request.tblUserCreationRequest;
import com.FinalExam.ClbManagement.dto.request.tblUserUpdateRequest;
import com.FinalExam.ClbManagement.entity.tblUser;
import com.FinalExam.ClbManagement.repository.tblUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class tblUserService {
    @Autowired
    private tblUserRepository tbluserRepository;

    public tblUser createUser(tblUserCreationRequest request){
        tblUser user = new tblUser();

        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setDob(request.getDob());

        return tbluserRepository.save(user);
    }

    public tblUser registerUser(RegisterRequest request){
        tblUser user = new tblUser();

        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setName(request.getName());

        return tbluserRepository.save(user);
    }

    public tblUser updateUser(int userId, tblUserUpdateRequest request) {
        tblUser user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setDob(request.getDob());

        return tbluserRepository.save(user);
    }

    public void deleteUser(int userId){
        tbluserRepository.deleteById(userId);
    }

    public List<tblUser> getUsers(){
        return tbluserRepository.findAll();
    }

    public tblUser getUser(int id){
        return tbluserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public tblUser getUserbyUserName(String username){
        return tbluserRepository.findByuserName(username).orElseThrow(() -> new RuntimeException("not found"));
    }

    public tblUser login(String UserName, String password) throws Exception {
        tblUser user = tbluserRepository.findByuserName(UserName.toLowerCase())
                .orElseThrow(() -> new Exception("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new Exception("Invalid password");
        }

        return user;
    }

}

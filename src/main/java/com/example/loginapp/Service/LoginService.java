package com.example.loginapp.Service;

import com.example.loginapp.Model.User;
import com.example.loginapp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    @Autowired
    UserRepo userRepo;

    public String login(String email, String password) {
        User foundUser = userRepo.findByEmail(email);
        if(foundUser == null) {
            return "Authentication failed: User not found";
        } else if (!foundUser.getPassword().equals(password)) {
            return "Password incorrect";
        }
        return "{\n" +
                "\"Message\":"+"\" Successfully Logged-in\"," +
                "\"Name\":"+foundUser.getFirstName()+foundUser.getLastName() +
                "}";
    }
}

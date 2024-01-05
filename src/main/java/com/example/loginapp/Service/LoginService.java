package com.example.loginapp.Service;

import com.example.loginapp.Model.User;
import com.example.loginapp.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LoginService {
    @Autowired
    private UserRepo userRepo;


    public String login(String email, String password) {
        System.out.println("....inside login...");
        User foundUser = userRepo.findByEmail(email);
        if(foundUser == null) {
            return "Authentication failed: User not found";
        } else if (!foundUser.getPassword().equals(password)) {
            return "Password incorrect";
        }
        return "{\n" +
                "\"Message\":"+"\"Successfully Logged-in\"," +
                "\"Name\": \""+ foundUser.getFirstName()+foundUser.getLastName() + "\"" +
                "}";
    }

    public User createProduct(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}

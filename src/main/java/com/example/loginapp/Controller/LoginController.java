package com.example.loginapp.Controller;

import com.example.loginapp.Model.User;
import com.example.loginapp.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = {"/","/login"})
    public String login(@RequestBody Map<String,Object> map) {
        return loginService.login(map.get("email").toString(), map.get("password").toString());
    }

    @PostMapping("/add-user")
    public User saveProduct(@RequestBody User user) {
        return loginService.createProduct(user);
    }


    @GetMapping("/get-users")
    public List<User> getUsers() {
        return loginService.getAllUsers();
    }
}

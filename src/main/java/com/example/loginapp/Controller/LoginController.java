package com.example.loginapp.Controller;

import com.example.loginapp.Repository.UserRepo;
import com.example.loginapp.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/login")
    public String login(@RequestBody Map<String,Object> map) {
        return loginService.login(map.get("email").toString(), map.get("password").toString());
    }
}

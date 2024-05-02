package com.www.serverWWW;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login(){
        return "index.html";
    }
    @Autowired
    private UserService userService;
    @GetMapping("/home")
    public String home(){
        return "home.html";
    }
    @GetMapping("/loginFailure")
    public String loginFailure() {
        return "failureLogin.html";
    }
    @PostMapping("/signUp")
    public String newUser(@RequestParam String username,@RequestParam String password){
        userService.createUser(username,password);
        return "index.html";
    }
    @GetMapping("/signUpView")
    public String signUpView(){
        return "signUpView.html";
    }
}

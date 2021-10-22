package com.example.demo.controller;

import com.example.demo.model.Token;
import com.example.demo.repo.AppUserRepo;
import com.example.demo.repo.TokenRepo;
import com.example.demo.service.UserService;
import com.example.demo.model.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

@Controller
public class UserController {

    private AppUserRepo appUserRepo;
    private TokenRepo tokenRepo;
    private UserService userService;

    public UserController(TokenRepo tokenRepo, UserService userService, AppUserRepo appUserRepo) {
        this.tokenRepo = tokenRepo;
        this.userService = userService;
        this.appUserRepo= appUserRepo;
    }

//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello(){
//        return "hello";
//    }
    @GetMapping("/hello")
    public String forUser(Principal principal, Model model){
        model.addAttribute("name", principal.getName());
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();

        model.addAttribute("authorities", authorities);
        model.addAttribute("details", details);
        return "hello";
    }

    @GetMapping("/sign-up")
    public String signup(Model model){
        model.addAttribute("user", new AppUser());
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(AppUser appUser){
        userService.addUser(appUser);
        return "sign-up";
    }

    @GetMapping("/token")
    public String check(@RequestParam String value){
        Token byValue = tokenRepo.findByValue(value);
        AppUser appUser = byValue.getAppUser();
        appUser.setEnabled(true);
        appUserRepo.save(appUser);
        return "hello";
    }
}

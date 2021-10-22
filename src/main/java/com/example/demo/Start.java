package com.example.demo;

import com.example.demo.model.AppUser;
import com.example.demo.repo.AppUserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Start {

    private AppUserRepo appUserRepo;

    public Start(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;

        /* users to test
        AppUser appUser = new AppUser();
        appUser.setUsername("admin1");
        appUser.setPassword(passwordEncoder.encode("admin1"));
        appUser.setRole("ROLE_ADMIN");
        appUser.setEnabled(true);
        appUserRepo.save(appUser);

        //user with unencrypted password        
        AppUser appUser3 = new AppUser();
        appUser.setUsername("user1");
        appUser.setPassword("user1");
        appUser.setRole("ROLE_USER");
        appUser.setEnabled(true);
        appUserRepo.save(appUser);
        */

    }


}

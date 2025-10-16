package com.hng.catapp.controller;

import com.hng.catapp.model.MyProfile;
import com.hng.catapp.model.User;
import com.hng.catapp.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class ProfileController {

    @Autowired
    private CatService catService;

    // Get profile
    @GetMapping("/me")
    public ResponseEntity<MyProfile> getProfile(){
        MyProfile myProfile = new MyProfile();
        User user = new User(
                "Adedayo Theophilus Adedeji",
                "adedejitheophilus2018@gmail.com",
                "Java/Springboot");

        myProfile.setUser(user);
        myProfile.setStatus("success");
        myProfile.setTimestamp(Instant.now());
        myProfile.setFact(catService.getCatFacts().getFact());

        return ResponseEntity.status(HttpStatus.OK).body(myProfile);
    }
}

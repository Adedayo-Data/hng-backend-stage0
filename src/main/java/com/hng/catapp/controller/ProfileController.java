package com.hng.catapp.controller;

import com.hng.catapp.model.MyProfile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    // Get profile
    @GetMapping("/me")
    public ResponseEntity<MyProfile> getProfile(){
        User
    }
}

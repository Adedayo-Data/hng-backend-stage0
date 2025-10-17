package com.hng.catapp.controller;

import com.hng.catapp.model.MyProfile;
import com.hng.catapp.service.ProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@Slf4j
@AllArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    // Get profile
    @GetMapping("/me")
    public ResponseEntity<MyProfile> getProfile(){
        log.info("GET /me called to fetch cat fact");
        return ResponseEntity.status(HttpStatus.OK).body(profileService.fetchMyProfile());
    }
}

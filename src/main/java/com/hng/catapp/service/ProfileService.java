package com.hng.catapp.service;

import com.hng.catapp.model.MyProfile;
import com.hng.catapp.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
@AllArgsConstructor
public class ProfileService {

    private final CatService catService;

    public MyProfile fetchMyProfile(){
        log.info("Attempting to build cat fact json");
        MyProfile myProfile = new MyProfile();

        try{
            User user = new User(
                    "Adedayo Theophilus Adedeji",
                    "adedejitheophilus2018@gmail.com",
                    "Java/Springboot");

            myProfile.setUser(user);
            myProfile.setStatus("success");
            myProfile.setTimestamp(Instant.now());
            myProfile.setFact(catService.fetchCatFact());
        }catch(Exception e){
            log.error("Error fetching cat data {}", e.getMessage());
            User user = new User(
                    "Adedayo Theophilus Adedeji",
                    "adedejitheophilus2018@gmail.com",
                    "Java/Springboot");
            myProfile.setUser(user);
            myProfile.setStatus("success");
            myProfile.setTimestamp(Instant.now());
            myProfile.setFact("Unable to fetch cat facts at this time.");

        }

        return myProfile;
    }
}

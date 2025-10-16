package com.hng.catapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalTime;

@Getter
@Setter
public class MyProfile {

    private String status;
    private User user;
    private Instant timestamp;
    private String fact;

}

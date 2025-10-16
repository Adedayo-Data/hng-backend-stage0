package com.hng.catapp.service;

import com.hng.catapp.model.CatFacts;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CatService {

    private final RestTemplate restTemplate;

    // Request to cat API
    public CatFacts getCatFacts(){


        String url = "https://catfact.ninja/fact";
        return restTemplate.getForObject(url, CatFacts.class);
    }
}

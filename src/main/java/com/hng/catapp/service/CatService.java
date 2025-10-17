package com.hng.catapp.service;

import com.hng.catapp.model.CatFacts;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class CatService {

    private final RestTemplate restTemplate;
    private final String apiUrl;

    public CatService(
            RestTemplate restTemplate,
            @Value("${catfact-api-url}") String apiUrl
            ){
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    // Request to cat API
    public String fetchCatFact(){
        log.info("Attemping to fetch cat fact from API {}", apiUrl);
        try{
            CatFacts facts = restTemplate.getForObject(apiUrl, CatFacts.class);

            if(facts == null || facts.getFact() == null){
                throw new RuntimeException("Invalid Response");
            }

            return facts.getFact();
        }catch(Exception ex){
            log.error("Failed to fetch cat data {}", ex.getMessage());
            System.err.println("Failed to fetch data from API " + ex.getMessage());
            throw new RuntimeException("Failed to fetch cat fact from API");
        }
    }
}

package com.hng.catapp.service;

import com.hng.catapp.model.CatFacts;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
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

        try{
            System.out.println("Api string: " +apiUrl   );
            CatFacts facts = restTemplate.getForObject(apiUrl, CatFacts.class);

            if(facts == null || facts.getFact() == null){
                throw new RuntimeException("Invalid Response");
            }

            return facts.getFact();
        }catch(Exception ex){
            System.err.println("Failed to fetch data from API " + ex.getMessage());
            throw new RuntimeException("Failed to fetch cat fact from API");
        }
    }
}

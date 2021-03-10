package com.anma.gql.graphql1;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Controller
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<?> testController() {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>("some body", headers);
        
        RequestEntity<Void> requestEntity = RequestEntity.get(URI.create("http://localhost:8080/request")).headers(headers).build();

        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/request", request, String.class);

        return response;
    }
}

package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class TransfersService {


    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();
    String TOKEN;

    public TransfersService(String url) {
        this.baseUrl = url;
    }

    public void createTransfer(long fromId, long toId, double amount, String token) {
        TOKEN = token;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(TOKEN);
        HttpEntity<Transfer> entity = new HttpEntity<>(headers);

        restTemplate.postForObject(
                baseUrl + "transfers/create/"+fromId+"/"+toId+"/"+amount, entity, Transfer.class);



    }

    }



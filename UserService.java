package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.User;
import org.springframework.web.client.RestTemplate;


public class UserService {

    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();

    public UserService(String url) {
        this.baseUrl = url;
    }

    public void listUsers(long currentId) {
        User[] users = restTemplate.getForObject(baseUrl + "users", User[].class);
        System.out.println("User ID     Name");
        for(int i = 0; i <= users.length - 1; i++) {
            User user = users[i];
            if(user.getId() != currentId) {
            System.out.println("("+user.getId()+")"+"      "+user.getUsername());
            }
        }

        }

    }


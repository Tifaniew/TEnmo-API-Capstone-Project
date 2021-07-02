package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;



public class AccountService {

    private String baseUrl;
    private RestTemplate restTemplate = new RestTemplate();
    public static String TOKEN;

    public AccountService(String url) {
        this.baseUrl = url;
    }

    public Account getAccount(long userId, String token) {
        TOKEN = token;
        Account account = restTemplate
                .exchange(baseUrl + "account/" + userId, HttpMethod.GET, makeAuthEntity(), Account.class).getBody();
        return account;
    }

    public void updateBalance(long accountId, double amount, String token) {
        TOKEN = token;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(TOKEN);
        HttpEntity<Account> entity = new HttpEntity<>(headers);
        restTemplate.put(baseUrl+"account/update/"+accountId+"/"+amount, entity);
    }

    public boolean validRecipient(long recipientId, long currentUserId, String token) {
        TOKEN = token;
        Account account = restTemplate
                .exchange(baseUrl + "account/" + recipientId, HttpMethod.GET, makeAuthEntity(), Account.class).getBody();
        if(account != null && currentUserId != account.getUserId()) {
            return true;
        } else {
            System.out.println("\r\n-------------------------");
            System.out.println("*** Invalid Recipient ***");
            System.out.println("-------------------------");
            return false;
        }

    }

    public boolean accountHasEnoughMoney(long userId, double amount, String token) {
        TOKEN = token;
        Account account = restTemplate
                .exchange(baseUrl + "account/" + userId, HttpMethod.GET, makeAuthEntity(), Account.class).getBody();
        if(account != null && account.getBalance() >= amount) {
            return true;
        } else {
            System.out.println("\r\n--------------------------");
            System.out.println("*** Insufficient Funds ***");
            System.out.println("--------------------------");

            return false;
        }
    }


    private HttpEntity makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(TOKEN);
        HttpEntity entity = new HttpEntity<>(headers);
        return entity;
    }


}

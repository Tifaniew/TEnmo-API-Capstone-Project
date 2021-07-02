package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("isAuthenticated()")
public class AccountController {

    private AccountDao dao;
    public AccountController(AccountDao dao) {
        this.dao = dao;
    }

    @RequestMapping(path = "account/{userId}", method = RequestMethod.GET)
    public Account getAccount(@PathVariable Long userId) {
        return dao.getAccount(userId);
    }

    @RequestMapping(path = "account/update/{accountId}/{amount}", method = RequestMethod.PUT)
    public void updateBalance(@PathVariable long accountId, @PathVariable double amount) {
        dao.updateBalance(accountId, amount);
    }



}

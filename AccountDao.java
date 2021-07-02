package com.techelevator.tenmo.dao;


import com.techelevator.tenmo.model.Account;

public interface AccountDao {

    Account getAccount(long userId);

    void updateBalance(long accountId, double amount);
}

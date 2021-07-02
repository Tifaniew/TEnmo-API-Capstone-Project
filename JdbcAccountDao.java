package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Account getAccount(long userId) {
        String sql = "SELECT * FROM accounts WHERE user_id=?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);

        Account account = null;

        if(result.next()) {
            account = mapToAccount(result);
        }
        return account;
    }
    @Override
    public void updateBalance(long accountId, double amount) {
        String sql = "Update accounts SET balance = ? WHERE account_id = ?";
        jdbcTemplate.update(sql, amount, accountId);
    }

    private Account mapToAccount(SqlRowSet rowSet) {
        Account account = new Account();
        account.setAccountId(rowSet.getLong("account_id"));
        account.setUserId(rowSet.getLong("user_id"));
        account.setBalance(rowSet.getDouble("balance"));
        return account;
    }
}

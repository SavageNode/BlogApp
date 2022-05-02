/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blogweb.dao;

import com.blogweb.entities.Account;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dejan Savic
 */
@Repository
public class AccountDaoDB implements AccountDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Account getAccountById(int id) {

        try {
            final String SELECT_ACCOUNT_BY_ID = "SELECT id, username FROM account WHERE id = ?";
            return jdbc.queryForObject(SELECT_ACCOUNT_BY_ID, new AccountMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        final String SELECT_ALL_ACCOUNTS = "SELECT * FROM account";
        return jdbc.query(SELECT_ALL_ACCOUNTS, new AccountMapper());
    }

    @Override
    public Account addAccount(Account account) {
        final String INSERT_ACCOUNT = "INSERT INTO account(username,password,admin) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_ACCOUNT,
                account.getUsername(),
                account.getPassword(),
                account.isAdmin());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        account.setId(newId);
        return account;
    }

    @Override
    @Transactional
    public void deleteAccountById(int id) {
        final String DELETE_ACCOUNT = "DELETE FROM account WHERE id = ?";
        jdbc.update(DELETE_ACCOUNT, id);
    }

    public static final class AccountMapper implements RowMapper<Account> {

        @Override
        public Account mapRow(ResultSet rs, int index) throws SQLException {
            Account account = new Account();
            account.setId(rs.getInt("id"));
            account.setAdmin(rs.getBoolean("admin"));
            account.setUsername(rs.getString("username"));
            account.setPassword(rs.getString("password"));

            return account;
        }
    }

}

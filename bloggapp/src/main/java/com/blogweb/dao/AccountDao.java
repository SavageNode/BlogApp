/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blogweb.dao;

import com.blogweb.entities.Account;
import java.util.List;



/**
 *
 * @author Dejan Savic
 */
public interface AccountDao {
    Account getAccountById(int id);
    
    List<Account> getAllAccounts();
    
    Account addAccount(Account account);
    
    
    void deleteAccountById(int id);
}

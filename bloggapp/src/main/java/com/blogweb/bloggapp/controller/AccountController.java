/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blogweb.bloggapp.controller;

import com.blogweb.dao.AccountDao;
import com.blogweb.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author mihrettadesse
 */
@Controller
public class AccountController {
    @Autowired
   AccountDao accountDao;

   @PostMapping("creataccount")
    public String createAccount(String username, String email, String password) {
        Account  account = new  Account();
         account.setUsername(username);
         account.setEmail(email);
         account.setPassword(password);
         accountDao.createAccount(account);
        
        return "redirect:/accounts";
    }
}

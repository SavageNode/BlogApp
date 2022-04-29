/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blogweb.bloggapp.controller;

import com.blogweb.dao.AccountDao;
import com.blogweb.entities.Account;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author mihrettadesse
 */
@Controller
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @PostMapping("addaccount")
    public String addAccount(String username, String email, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setEmail(email);
        account.setPassword(password);
        accountDao.addAccount(account);

        return "redirect:/accounts";
    }

    @GetMapping("account")
    public String displayAccount(Model model) {
        List<Account> account = accountDao.getAllAccounts();
        model.addAttribute("account", account);
        return "accounts";
    }

    @GetMapping("accountDetail")
    public String accountDetail(Integer id, Model model) {
        Account account = accountDao.getAccountById(id);
        model.addAttribute("account", account);
        return "accountDetail";
    }

    @GetMapping("deleteAccount")
    public String deleteAccount(Integer id) {
        accountDao.deleteAccountById(id);
        return "redirect:/account";
    }
}

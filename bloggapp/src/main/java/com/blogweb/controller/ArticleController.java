/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blogweb.controller;

import com.blogweb.dao.ArticleDao;
import com.blogweb.entities.Article;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class ArticleController {

    @Autowired
    ArticleDao articleDao;

    @PostMapping("addarticle")
    public String addArticle(HttpServletRequest request) {
        String title = request.getParameter("title");
        String body = request.getParameter("body");
        //boolean admin = Boolean.parseBoolean(request.getParameter("admin"));


        Article article = new Article();
        article.setTitle(title);
     //   article.setCategory(category);
        article.setBody(body);
        articleDao.addArticle(article);

        return "redirect:/submit.html";
    }

    @GetMapping("articles")
    public String displayArticles(Model model) {
        List<Article> article = articleDao.getAllArticles();
        model.addAttribute("articles", article);
        return "articles";
    }

    @GetMapping("articleDetail")
    public String articleDetail(Integer id, Model model) {
        Article article = articleDao.getArticleById(id);
        model.addAttribute("article", article);
        return "articleDetail";
    }

    @GetMapping("deleteArticle")
    public String deleteArticle(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        articleDao.deleteArticleById(id);
        return "redirect:/articles";
    }
    @GetMapping("approveArticle")
    public String approveArticle(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        articleDao.approveArticleById(id);
        
        return "redirect:/articles";
    }

}

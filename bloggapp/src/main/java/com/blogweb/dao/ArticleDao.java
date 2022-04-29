/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.blogweb.dao;

import com.blogweb.entities.Article;
import java.util.List;

/**
 *
 * @author Dejan Savic
 */
public interface ArticleDao {
    Article getArticleById(int id);
    
    List<Article> getAllArticles();
    
    Article addArticle(Article article);
    
    Article getNewestArticle(Article article);
    
    void deleteArticleById(int id);
}

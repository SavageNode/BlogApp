/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blogweb.dao;

import com.blogweb.entities.Article;
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
public class ArticleDaoDB implements ArticleDao {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Article getArticleById(int id) {
        try {
            final String SELECT_ARTICLE_BY_ID = "SELECT * FROM article WHERE id = ?";
            return jdbc.queryForObject(SELECT_ARTICLE_BY_ID, new ArticleMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Article> getAllArticlesTrue() {
        final String SELECT_ALL_ARTICLES = "SELECT * FROM article WHERE article.approved IS true ORDER BY publishdate Desc";
        return jdbc.query(SELECT_ALL_ARTICLES, new ArticleMapper());
    }
    
    @Override
    public List<Article> getAllArticlesFalse() {
        final String SELECT_ALL_ARTICLES = "SELECT * FROM article WHERE article.approved IS false";
        return jdbc.query(SELECT_ALL_ARTICLES, new ArticleMapper());
    }

    @Override
    public Article addArticle(Article article) {
        final String INSERT_ARTICLE = "INSERT INTO article(title, category, body) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_ARTICLE,
                article.getTitle(),
                article.getCategory(),
                //article.getImgurl(),
                article.getBody()
                //article.getDate(),
               //article.isApproved()
                );
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        article.setArticleID(newId);
        return article;
    }

    @Override
    public Article getNewestArticle(Article article) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    @Transactional
    public void deleteArticleById(int id) {
        final String DELETE_ARTICLE = "DELETE FROM article WHERE id = ? ";
        jdbc.update(DELETE_ARTICLE, id);
    }
    
    @Override
    public void approveArticleById(int id){
        final String APPROVE_ARTICLE = "UPDATE article SET approved = 1 WHERE id = ?";
        jdbc.update(APPROVE_ARTICLE,id);
                
    }
    
    

    public static final class ArticleMapper implements RowMapper<Article> {

        @Override
        public Article mapRow(ResultSet rs, int index) throws SQLException {
            Article article = new Article();
            article.setArticleID(rs.getInt("id"));
            article.setTitle(rs.getString("title"));
            article.setCategory(rs.getString("category"));
            article.setBody(rs.getString("body"));
            article.setDate(rs.getDate("publishdate").toLocalDate());
            article.setApproved(rs.getBoolean("approved"));

            return article;
        }
    }

}

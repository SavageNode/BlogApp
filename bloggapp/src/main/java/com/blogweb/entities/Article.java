/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.blogweb.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Dejan Savic
 */
public class Article {

    private int articleID;
    private String title;
    private String category;
    private String imgurl;
    private String body;
    private String date;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.articleID;
        hash = 19 * hash + Objects.hashCode(this.title);
        hash = 19 * hash + Objects.hashCode(this.category);
        hash = 19 * hash + Objects.hashCode(this.imgurl);
        hash = 19 * hash + Objects.hashCode(this.body);
        hash = 19 * hash + Objects.hashCode(this.date);
        hash = 19 * hash + (this.approved ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (this.articleID != other.articleID) {
            return false;
        }
        if (this.approved != other.approved) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.imgurl, other.imgurl)) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }
    private boolean approved;

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

}

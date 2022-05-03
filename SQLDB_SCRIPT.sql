DROP DATABASE IF EXISTS ArticlesDB;
CREATE DATABASE ArticlesDB;

USE ArticlesDB;

CREATE TABLE article(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(30) NOT NULL,
    imageurl VARCHAR(50) NOT NULL,
    body text,
    publishdate date,
    approved boolean default false
);

CREATE TABLE category(
	id INT PRIMARY KEY auto_increment,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE article_category(
    articleId INT NOT NULL,
    categoryId INT NOT NULL,
    PRIMARY KEY(articleId, categoryId),
    FOREIGN KEY (articleId) REFERENCES article(id),
    FOREIGN KEY (categoryId) REFERENCES category(id)
);

CREATE TABLE account(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(50) NOT NULL,
    admin boolean default false
);

insert into account(id, username, password, admin) values
    ('1', 'admin', 'password', true),
    ('2', '236', '1', false);

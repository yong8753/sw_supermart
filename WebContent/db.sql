CREATE DATABASE supermarket;

use supermarket;

DROP TABLE member;
DROP TABLE shop;
DROP TABLE orderlist;

CREATE TABLE member(
    id VARCHAR(30) PRIMARY KEY,
    pass VARCHAR(30) not null,
    name VARCHAR(30) not null,
    tel int not null,
    addr varchar(200) not null,
    reg_date datetime,
    grade int not null default 0
);
CREATE TABLE shop(
    no int primary key AUTO_INCREMENT,
    shop_id VARCHAR(30) not null,
    product VARCHAR(30) not null,
    product_ex text not null,
    price int not null,
    status int not null default 0,
    classfy int not null default 0,
    addr varchar(300) not null,
    tel int not null
);
CREATE TABLE orderlist(
    no int primary key AUTO_INCREMENT,
    shop_id varchar(30) not null,
    member_id varchar(30) not null,
    orderlist text not null,
    addr varchar(300) not null,
    tel int not null
);

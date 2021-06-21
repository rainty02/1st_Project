create table member (
memcode integer constraint mem_PK primary key,
name varchar2(50) not null,
id varchar2(50) unique not null,
pw varchar2(50) not null,
address varchar2(255),
phone varchar2(30) not null,
point long
);

create table sale (
salecode integer primary key,
sname varchar2(50) not null,
price integer not null,
saledate date default sysdate,
memcode integer constraint sale_FK references member(memcode)
);
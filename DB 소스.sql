create table member (
memcode integer constraint mem_PK primary key,
name varchar2(50) not null,
id varchar2(50) unique not null,
pw varchar2(50) not null,
address varchar2(255),
phone varchar2(30) not null,
point number(10) default '0' not null
);

create table sale (
salecode integer constraint sale_PK primary key,
sname varchar2(50) not null,
price integer not null,
saledate date default sysdate,
memcode integer constraint sale_FK references member(memcode)
);

desc member;
select * from member order by memcode;
select * from member;
insert into member (memcode, name, id, pw, address, phone) values (member_sq.nextval, 'name', 'f', '123', '서울', '02');

commit;
select * from member where id = 'a';
create sequence member_sq
start with 1;

drop table member;
drop table sale;
insert into member values(member_sq.nextval, '?', '?', '?', '?', '?');
update member set name = ?, pw =?, address = ?, phone = ? where =
select id from member where = 
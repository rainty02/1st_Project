-- member 테이블
create table member (
memcode integer constraint mem_PK primary key,
name varchar2(50) unique not null,
id varchar2(50) unique not null,
pw varchar2(50) not null,
address varchar2(255),
phone varchar2(30) not null,
point number(10) default '0' not null
);
-- sale 테이블
create table sale (
salecode integer constraint sale_PK primary key,
sname varchar2(50) not null,
price integer not null,
saledate date default sysdate,
id varchar2(50) constraint sale_FK references member(id)
);
-- member 시퀀스
create sequence member_sq
start with 1;

-- member 전체
select * from member;

-- member 값
-- id는 a,b,c순
-- 비밀번호는 1234 통일
insert into member (memcode, name, id, pw, address, phone) values (member_sq.nextval, '김은선', 'a', '1234', '서울', '01012345678');
insert into member (memcode, name, id, pw, address, phone) values (member_sq.nextval, '위세라', 'b', '1234', '서울', '01012345678');
insert into member (memcode, name, id, pw, address, phone) values (member_sq.nextval, '이윤성', 'c', '1234', '서울', '01012345678');
insert into member (memcode, name, id, pw, address, phone) values (member_sq.nextval, '이현우', 'd', '1234', '서울', '01012345678');
insert into member (memcode, name, id, pw, address, phone) values (member_sq.nextval, '박지성', 'e', '1234', '서울', '01012345678');
insert into member (memcode, name, id, pw, address, phone) values (member_sq.nextval, '이강인', 'f', '1234', '서울', '01012345678');

-- 커밋
commit;


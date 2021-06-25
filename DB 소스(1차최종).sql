select * from menu;
select * from member;

alter table sale add count number(10) not null;

select rownum, menucode, mname, price from menu;

delete from menu where rownum = (select rownum from menu where rownum = 1);
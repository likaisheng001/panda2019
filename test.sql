-- 存储过程
delimiter $$
create procedure sp_sumofrow(out rows int)
BEGIN
  DECLARE cid int;
  DECLARE found boolean DEFAULT true;
  DECLARE cur_cid CURSOR for
    select seller_id from seller;
  DECLARE CONTINUE handler for not FOUND
    set found = FALSE ;
  set rows = 0;
  open cur_cid;
  FETCH cur_cid into cid;
  while FOUND do
    set rows = rows + 1;
    FETCH cur_cid into cid;
  end while;
  close cur_cid;
end $$
delimiter ;

delimiter $$
create function fn_search(cid int)
  returns char(10)
  deterministic
begin
  DECLARE str char(10);
  select seller_name into str from seller
    where seller_id = cid;
  if str is NULL then
    return(select '没有此供应商');
  else
    return(select str);
  end if;
end $$
delimiter ;

delimiter $$
create procedure sp_sum(out rows int)
BEGIN
  declare cid int;
  declare found boolean default true;
  declare cur_cid cursor for
    select seller_id from seller;
  declare continue handler for not found
    set found = false;
  set rows = 0;
  open cur_cid;
  fetch cur_cid into cid;
  while found do
    set rows = rows+1;
    fetch cur_cid into cid;
  end while;
  close cur_cid;
end$$
delimiter ;

delimiter $$
create function fn_search(cid int)
  returns char(20)
  deterministic
begin
  declare str char(20);
  select seller_name into str from seller
    where seller_id = cid;
  if str is NULL then
    return(select '没有该供应商');
  else
    return (select str);
  end if;
end $$
delimiter ;

create table user(
  id int AUTO_INCREMENT primary key,
  username char(20) not null,
  logintime TIMESTAMP not null DEFAULT CURRENT_TIMESTAMP comment '登录时间'
)
insert into user(username,logintime) value("vulcan",'2019-08-20 16:05:06');
insert into user(username,logintime) value("vulcan",'2019-09-01 16:05:06');
insert into user(username,logintime) value("vulcan",'2019-08-30 16:05:06');
insert into user(username,logintime) value("tom",'2019-09-02 16:05:06');
insert into user(username,logintime) value("tina",'2019-09-02 16:05:06');
insert into user(username,logintime) value("tin",'2019-09-02 16:05:06');
insert into user(username,logintime) value("tin",'2019-08-20 16:05:06');

select count(id) num,username from user
  where logintime >= date_sub(curdate(),interval 3 day)
  group by username order by num desc limit 1;

select * from user
  GROUP  by username order by logintime;

SELECT * FROM (SELECT * from table where isDel = 0 ORDER BY createTime DESC limit 10)  t
GROUP BY id ;

delete from user where id not in(
  select id from(
    select * from user order by logintime desc
  )t GROUP by username
)

select * from user group by username;

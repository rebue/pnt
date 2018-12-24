-- 添加账号信息
insert into pnt.PNT_ACCOUNT (ID,POINT,INCOME,TOTAL_INCOME,IS_LOCKED,MODIFIED_TIMESTAMP)
select ID, 0, 0, 0, 0, unix_timestamp(now()) from suc.SUC_USER;
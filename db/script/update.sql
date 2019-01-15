alter table PNT_ACCOUNT          		drop column  	IS_LOCKED;
alter table PNT_ACCOUNT			 		add  DAY_INCOME_STAT_DATE date comment '日收益统计日期';

--------------------------------------------以下已更新至线上-------------------------------------------
drop table if exists PNT_INCOME_LOG;

/*==============================================================*/
/* Table: PNT_INCOME_LOG                                        */
/*==============================================================*/
create table PNT_INCOME_LOG
(
   ID                   bigint not null comment '收益日志ID',
   ACCOUNT_ID           bigint not null comment '积分账户ID(等于SUC的用户ID)',
   INCOME_LOG_TYPE      tinyint not null comment '收益日志类型(1: 日收益； 2: 转出收益)',
   INCOME_BEFORE_CHANGED numeric(20,10) not null comment '改变前的收益',
   CHANGED_INCOME       numeric(20,10) not null comment '改变的收益',
   INCOME_AFTER_CHANGED numeric(20,10) not null comment '改变后的收益(改变后的收益=改变前的收益+改变的收益)',
   CHANGED_TITILE       varchar(30) not null comment '改变收益的标题',
   STAT_DATE            date comment '统计日期(日收益的日期)',
   MODIFIED_TIMESTAMP   bigint not null comment '修改时间戳',
   primary key (ID),
   unique key AK_INCOME_LOG_TYPE_AND_STAT_DATE (INCOME_LOG_TYPE, STAT_DATE),
   unique key AK_ACCOUNT_ID_AND_INCOME_LOG_TYPE_AND_MODIFIED_TIMESTAMP (ACCOUNT_ID, INCOME_LOG_TYPE, MODIFIED_TIMESTAMP)
);

alter table PNT_INCOME_LOG comment '收益日志';

alter table PNT_INCOME_LOG add constraint FK_RELATIONSHIP_4 foreign key (ACCOUNT_ID)
      references PNT_ACCOUNT (ID) on delete restrict on update restrict;
      
      
alter table PNT_INCOME_LOG DROP INDEX AK_INCOME_LOG_TYPE_AND_STAT_DATE;
alter table PNT_INCOME_LOG add unique key AK_ACCOUNT_ID_AND_INCOME_LOG_TYPE_AND_STAT_DATE (ACCOUNT_ID, INCOME_LOG_TYPE, STAT_DATE);

------------------------------------------------------------以上已更新到线上-----------------------------------------------------------
alter table PNT_ACCOUNT add REG_TIME             datetime comment '注册日期';

      
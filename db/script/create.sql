/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/1/9 14:52:12                            */
/*==============================================================*/


drop table if exists PNT_ACCOUNT;

drop table if exists PNT_INCOME_LOG;

drop table if exists PNT_POINT_LOG;

/*==============================================================*/
/* Table: PNT_ACCOUNT                                           */
/*==============================================================*/
create table PNT_ACCOUNT
(
   ID                   bigint not null comment '积分账户ID(等于SUC的用户ID)',
   POINT                decimal(18,4) not null default 0 comment '当前积分',
   INCOME               numeric(20,10) not null default 0 comment '当前收益',
   TOTAL_INCOME         numeric(20,10) not null default 0 comment '历史总共收益',
   MODIFIED_TIMESTAMP   bigint not null comment '修改时间戳',
   DAY_INCOME_STAT_DATE date comment '日收益统计日期',
   primary key (ID)
);

alter table PNT_ACCOUNT comment '积分账户信息';

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
   unique key AK_INCOME_LOG_TYPE_AND_STAT_DATE (INCOME_LOG_TYPE, STAT_DATE)
);

alter table PNT_INCOME_LOG comment '收益日志';

/*==============================================================*/
/* Table: PNT_POINT_LOG                                         */
/*==============================================================*/
create table PNT_POINT_LOG
(
   ID                   bigint not null comment '积分日志ID',
   ACCOUNT_ID           bigint not null comment '积分账户ID(等于SUC的用户ID)',
   POINT_LOG_TYPE       tinyint not null comment '积分日志类型',
   POINT_BEFORE_CHANGED decimal(18,4) not null comment '改变前的积分',
   CHANGED_POINT        decimal(18,4) not null comment '改变的积分',
   POINT_AFTER_CHANGED  decimal(18,4) not null comment '改变后的积分(改变后的积分=改变前的积分+改变的积分)',
   CHANGED_TITILE       varchar(30) not null comment '改变积分的标题',
   CHANGED_DETAIL       varchar(200) comment '改变积分的详情',
   ORDER_ID             bigint not null comment '订单ID',
   ORDER_DETAIL_ID      bigint comment '订单详情ID',
   MODIFIED_TIMESTAMP   bigint not null comment '修改时间戳',
   OLD_MODIFIED_TIMESTAMP bigint not null comment '旧修改时间戳',
   primary key (ID),
   unique key AK_ACCOUNT_AND_LOG_TYPE_AND_ORDER (ACCOUNT_ID, POINT_LOG_TYPE, ORDER_ID, ORDER_DETAIL_ID)
);

alter table PNT_POINT_LOG comment '积分日志';

alter table PNT_INCOME_LOG add constraint FK_RELATIONSHIP_4 foreign key (ACCOUNT_ID)
      references PNT_ACCOUNT (ID) on delete restrict on update restrict;

alter table PNT_POINT_LOG add constraint FK_RELATIONSHIP_1 foreign key (ACCOUNT_ID)
      references PNT_ACCOUNT (ID) on delete restrict on update restrict;


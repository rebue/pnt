/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/18 10:34:36                          */
/*==============================================================*/


drop table if exists PNT_POINTS_LOG;

drop table if exists PNT_INCOME_LOG;

drop table if exists PNT_ACCOUNT;

drop table if exists PNT_LOG_TYPE;

/*==============================================================*/
/* Table: PNT_ACCOUNT                                           */
/*==============================================================*/
create table PNT_ACCOUNT
(
   ID                   bigint not null comment '积分账户ID(等于SUC的用户ID)',
   POINTS               bigint not null comment '当前积分',
   INCOME               numeric(20,10) not null comment '当前收益',
   TOTAL_INCOME         numeric(20,10) not null comment '历史总共收益',
   IS_LOCKED            bool not null default false comment '是否锁定',
   MODIFIED_TIMESTAMP   bigint not null comment '修改时间戳',
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
   CHANGED_DETAIL       varchar(200) not null comment '改变收益的详情',
   STAT_DATE            date comment '统计日期(日收益的日期)',
   MODIFIED_TIMESTAMP   bigint not null comment '修改时间戳',
   OLD_MODIFIED_TIMESTAMP bigint not null comment '旧修改时间戳',
   primary key (ID),
   unique key AK_ACCOUNT_AND_MODIFIED_TS (ACCOUNT_ID, MODIFIED_TIMESTAMP),
   unique key AK_ACCOUNT_AND_OLD_MODIFIED_TS (ACCOUNT_ID, OLD_MODIFIED_TIMESTAMP)
);

alter table PNT_INCOME_LOG comment '收益日志';

/*==============================================================*/
/* Table: PNT_LOG_TYPE                                          */
/*==============================================================*/
create table PNT_LOG_TYPE
(
   ID                   varchar(30) not null comment '积分日志类型ID',
   TYPE_NAME            varchar(30) not null comment '积分日志类型名称',
   REMARK               varchar(120) comment '积分日志类型备注',
   primary key (ID),
   unique key AK_NAME (TYPE_NAME)
);

alter table PNT_LOG_TYPE comment '积分日志类型';

/*==============================================================*/
/* Table: PNT_POINTS_LOG                                        */
/*==============================================================*/
create table PNT_POINTS_LOG
(
   ID                   bigint not null comment '积分日志ID',
   ACCOUNT_ID           bigint not null comment '积分账户ID(等于SUC的用户ID)',
   POINTS_LOG_TYPE_ID   varchar(30) not null comment '积分日志类型ID',
   POINTS_BEFORE_CHANGED bigint not null comment '改变前的积分',
   CHANGED_POINTS       bigint not null comment '改变的积分',
   POINTS_AFTER_CHANGED bigint not null comment '改变后的积分(改变后的积分=改变前的积分+改变的积分)',
   CHANGED_TITILE       varchar(30) not null comment '改变积分的标题',
   CHANGED_DETAIL       varchar(200) comment '改变积分的详情',
   ORDER_ID             bigint not null comment '订单ID',
   ORDER_DETAIL_ID      bigint comment '订单详情ID',
   MODIFIED_TIMESTAMP   bigint not null comment '修改时间戳',
   OLD_MODIFIED_TIMESTAMP bigint not null comment '旧修改时间戳',
   primary key (ID),
   unique key AK_ACCOUNT_AND_LOG_TYPE_AND_ORDER (ACCOUNT_ID, POINTS_LOG_TYPE_ID, ORDER_ID, ORDER_DETAIL_ID)
);

alter table PNT_POINTS_LOG comment '积分日志';

alter table PNT_INCOME_LOG add constraint FK_RELATIONSHIP_4 foreign key (ACCOUNT_ID)
      references PNT_ACCOUNT (ID) on delete restrict on update restrict;

alter table PNT_POINTS_LOG add constraint FK_RELATIONSHIP_1 foreign key (ACCOUNT_ID)
      references PNT_ACCOUNT (ID) on delete restrict on update restrict;

alter table PNT_POINTS_LOG add constraint FK_RELATIONSHIP_2 foreign key (POINTS_LOG_TYPE_ID)
      references PNT_LOG_TYPE (ID) on delete restrict on update restrict;


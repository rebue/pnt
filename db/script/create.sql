/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/11 21:42:45                          */
/*==============================================================*/


drop table if exists PNT_ACCOUNT;

drop table if exists PNT_LOG;

drop table if exists PNT_LOG_TYPE;

/*==============================================================*/
/* Table: PNT_ACCOUNT                                           */
/*==============================================================*/
create table PNT_ACCOUNT
(
   ID                   bigint not null comment '积分账户ID(等于SUC的用户ID)',
   POINTS               numeric(18,4) not null comment '当前积分数量',
   IS_LOCKED            bool not null default false comment '是否锁定',
   primary key (ID)
);

alter table PNT_ACCOUNT comment '积分账户信息';

/*==============================================================*/
/* Table: PNT_LOG                                               */
/*==============================================================*/
create table PNT_LOG
(
   ID                   bigint not null comment '积分日志ID',
   ACCOUNT_ID           bigint not null comment '积分账户ID(等于SUC的用户ID)',
   LOG_TYPE_ID          bigint not null comment '积分日志类型ID',
   CHANGED_POINTS       numeric(18,4) not null comment '改变积分的数量',
   CHANGED_TITILE       varchar(30) not null comment '改变积分的标题',
   CHANGED_DETAIL       varchar(200) comment '改变积分的详情',
   ORDER_ID             bigint not null comment '订单ID',
   ORDER_DETAIL_ID      bigint comment '订单详情ID',
   CHANGED_TIMESTAMP    bigint not null comment '改变积分的时间戳',
   primary key (ID),
   unique key AK_ACCOUNT_AND_LOG_TYPE_AND_ORDER (ACCOUNT_ID, LOG_TYPE_ID, ORDER_ID, ORDER_DETAIL_ID)
);

alter table PNT_LOG comment '积分日志';

/*==============================================================*/
/* Table: PNT_LOG_TYPE                                          */
/*==============================================================*/
create table PNT_LOG_TYPE
(
   ID                   bigint not null comment '积分日志类型ID',
   TYPE_CODE            varchar(30) not null comment '积分日志类型编码',
   TYPE_NAME            varchar(30) not null comment '积分日志类型名称',
   REMARK               varchar(200) comment '积分日志类型备注',
   primary key (ID)
);

alter table PNT_LOG_TYPE comment '积分日志类型';

alter table PNT_LOG add constraint FK_RELATIONSHIP_1 foreign key (ACCOUNT_ID)
      references PNT_ACCOUNT (ID) on delete restrict on update restrict;

alter table PNT_LOG add constraint FK_RELATIONSHIP_2 foreign key (LOG_TYPE_ID)
      references PNT_LOG_TYPE (ID) on delete restrict on update restrict;


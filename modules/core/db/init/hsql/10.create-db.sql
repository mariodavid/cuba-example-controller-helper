-- begin CECH_PRODUCT
create table CECH_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    CATEGORY_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end CECH_PRODUCT
-- begin CECH_PRODUCT_CATEGORY
create table CECH_PRODUCT_CATEGORY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end CECH_PRODUCT_CATEGORY
-- begin CECH_ORDER
create table CECH_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_DATE date,
    ORDER_NR integer not null,
    --
    primary key (ID)
)^
-- end CECH_ORDER
-- begin CECH_LINE_ITEM
create table CECH_LINE_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT_CATEGORY_ID varchar(36) not null,
    PRODUCT_ID varchar(36) not null,
    PRICE integer,
    ORDER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end CECH_LINE_ITEM

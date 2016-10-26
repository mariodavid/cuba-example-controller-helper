-- begin CECH_PRODUCT
alter table CECH_PRODUCT add constraint FK_CECH_PRODUCT_CATEGORY foreign key (CATEGORY_ID) references CECH_PRODUCT_CATEGORY(ID)^
create index IDX_CECH_PRODUCT_CATEGORY on CECH_PRODUCT (CATEGORY_ID)^
-- end CECH_PRODUCT
-- begin CECH_ORDER
create unique index IDX_CECH_ORDER_UNIQ_ORDER_NR on CECH_ORDER (ORDER_NR) ^
-- end CECH_ORDER
-- begin CECH_LINE_ITEM
alter table CECH_LINE_ITEM add constraint FK_CECH_LINE_ITEM_PRODUCT_CATEGORY foreign key (PRODUCT_CATEGORY_ID) references CECH_PRODUCT_CATEGORY(ID)^
alter table CECH_LINE_ITEM add constraint FK_CECH_LINE_ITEM_PRODUCT foreign key (PRODUCT_ID) references CECH_PRODUCT(ID)^
alter table CECH_LINE_ITEM add constraint FK_CECH_LINE_ITEM_ORDER foreign key (ORDER_ID) references CECH_ORDER(ID)^
create index IDX_CECH_LINE_ITEM_ORDER on CECH_LINE_ITEM (ORDER_ID)^
create index IDX_CECH_LINE_ITEM_PRODUCT_CATEGORY on CECH_LINE_ITEM (PRODUCT_CATEGORY_ID)^
create index IDX_CECH_LINE_ITEM_PRODUCT on CECH_LINE_ITEM (PRODUCT_ID)^
-- end CECH_LINE_ITEM

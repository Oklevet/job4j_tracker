create schema if not exists item;
create table if not exists item.items (
   id serial primary key,
   "name" text,
   created timestamp
);
commit;

--drop table item.items;
--select * from item.items;
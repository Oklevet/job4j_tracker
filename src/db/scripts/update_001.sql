create schema if not exists item;
create table if not exists item.items (
   id serial primary key,
   "name" varchar(2000)
);

--drop table items;
--select * from items;
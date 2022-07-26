drop database if exists `challenge_backend`;
create database `challenge_backend`;
use `challenge_backend`;

drop table if exists `item`;
create table `item` (
    id_item bigint primary key auto_increment,
    name varchar(100) not null,
    date timestamp not null,
    dimension bigint not null
);

drop table if exists `dimension`;
create table `dimension` (
    id_dimension bigint primary key auto_increment,
    weight decimal(5,2) not null,
    height decimal(5,2) not null,
    width decimal(5,2) not null,
    length decimal(5,2) not null
); 

alter table `item` add constraint fk_itens_dimension foreign key (dimension) references dimension (id_dimension);

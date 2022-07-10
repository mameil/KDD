create table kdd.member
(
    loginId           varchar(255) not null unique,
    password          varchar(255),
    role              varchar(10),
    name              varchar(255),
    birthDateYYYYMMDD varchar(6),
    married           boolean default 0,
    email             varchar(255),
    oldAddr           varchar(255),
    addr              varchar(255),
    addrDetail        varchar(255),
    zipCode           varchar(6),
    created           DATETIME,
    updated           DATETIME,
    primary key (loginId)

);

select * from kdd.member;
desc kdd.member;

drop table kdd.member;
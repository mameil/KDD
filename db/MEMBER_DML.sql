create table kdd.member
(
    login_id           varchar(255) not null unique,
    password           varchar(255),
    role               varchar(10),
    name               varchar(255),
    birth_dateyyyymmdd varchar(8),
    married            boolean default 0,
    email              varchar(255),
    old_addr           varchar(255),
    addr               varchar(255),
    addr_detail        varchar(255),
    zip_code           varchar(6),
    created            DATETIME,
    updated            DATETIME,
    primary key (login_id)

);

select *
from kdd.member;
desc kdd.member;

drop table kdd.member;
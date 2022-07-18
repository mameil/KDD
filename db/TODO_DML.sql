create table kdd.todo
(
    id           number(255) not null unique,
    todo        varchar(255) not null,
    status         varchar(20),
    dont_date_string varchar(20),
    created            DATETIME,
    updated            DATETIME,
    primary key (id)

);

select *
from kdd.todo;
desc kdd.todo;

drop table kdd.todo;
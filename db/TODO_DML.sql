create table kdd.todo
(
    id               integer(255) not null unique,
    todo             varchar(255) not null,
    status           varchar(20),
    endDate varchar(20),
    created          DATETIME,
    updated          DATETIME,
    primary key (id)

);

select *
from kdd.todo;
desc kdd.todo;

drop table kdd.todo;
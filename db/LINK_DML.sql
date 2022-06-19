create table kdd.link
(
    url      varchar(255) not null unique ,
    category varchar(30)  not null,
    name     varchar(255),
    memo     varchar(255),
    created  DATETIME,
    updated  DATETIME,
    PRIMARY KEY (url)
);

drop table link;

desc link;

select count(*) from kdd.link;
select * from kdd.link;
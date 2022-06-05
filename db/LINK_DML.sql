create table link
(
    id       int(255) auto_increment unique,
    url      varchar(255) not null,
    category varchar(30)  not null,
    name     varchar(255),
    memo     varchar(255),
    created  DATETIME,
    updated  DATETIME,
    PRIMARY KEY (id)
);

drop table link;

desc link;

select * from kdd.link;

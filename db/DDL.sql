# show tables;


create table LINK
(
    id       int unique,
    url      varchar(255) not null,
    category varchar(30)  not null,
    name     varchar(255),
    memo     varchar(255),
    created  DATETIME,
    updated  DATETIME,
    PRIMARY KEY (id)
);

create table BOOK
(
    id          varchar(255) not null unique,
    name        varchar(255),
    url         varchar(255),
    recommender varchar(30),
    PRIMARY KEY (id)
);

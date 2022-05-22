# show tables;


create table LINK
(
    url      varchar(255) not null unique,
    category varchar(30)  not null,
    name     varchar(255),
    memo     varchar(255),
    PRIMARY KEY (url)
);

create table book
(
    id      varchar(255) not null unique,
    name     varchar(255),
    url     varchar(255),
    recommender varchar(30),
    PRIMARY KEY (id)
);

show tables;
desc book;
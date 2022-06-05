# show tables;

create table BOOK
(
    id          varchar(255) not null unique,
    name        varchar(255),
    url         varchar(255),
    recommender varchar(30),
    PRIMARY KEY (id)
);

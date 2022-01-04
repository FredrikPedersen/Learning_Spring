drop table if exists BOOK;
drop table if exists AUTHOR;

create table BOOK
(
    ID        IDENTITY not null,
    ISBN      varchar(255),
    PUBLISHER varchar(255),
    TITLE     varchar(255),
    AUTHOR_ID BIGINT,
    primary key (id)
);

create table AUTHOR (
    ID         IDENTITY not null,
    FIRST_NAME varchar(255),
    LAST_NAME  varchar(255),
    primary key (id)
);
drop table if exists book;

create table book (
    ID        serial not null,
    ISBN      varchar(255),
    PUBLISHER varchar(255),
    TITLE     varchar(255),
    primary key (id)
);
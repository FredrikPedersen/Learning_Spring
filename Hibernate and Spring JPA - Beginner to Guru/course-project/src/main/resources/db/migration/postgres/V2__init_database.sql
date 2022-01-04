create table BOOK (
    ID        serial8 not null,
    ISBN      varchar(255),
    PUBLISHER varchar(255),
    TITLE     varchar(255),
    primary key (id)
);
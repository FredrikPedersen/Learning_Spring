drop table if exists book cascade;
drop table if exists author;

create table book (
    id        serial8 not null,
    isbn      varchar(255),
    publisher varchar(255),
    title     varchar(255),
    author_id int8,
    primary key (id)
);

create table author (
    id         serial8 not null,
    first_name varchar(255),
    last_name  varchar(255),
    primary key (id)
);

alter table book
add constraint fk_book_author foreign key (author_id) references author (id);

insert into author (first_name, last_name)
values ('Brandon', 'Sanderson');

insert into book (isbn, publisher, title, author_id)
values ('978-0-7653-2635-5', 'Tor Books', 'The Way of Kings', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('0-7653-1178-X', 'Tor Books', 'Mistborn', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('978-0-7653-2030-8', 'Tor Books', 'Warbreaker', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into author (first_name, last_name)
values ('J.R.R.', 'Tolkien');

insert into book (isbn, publisher, title, author_id)
values ('9780007136599', 'George Allen & Unwin', 'The Fellowship of the Ring', (select id from author where first_name = 'J.R.R.' and last_name = 'Tolkien'));

insert into author (first_name, last_name)
values ('George R. R.', 'Martin');

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'Voyager Books', 'A Game of Thrones', (select id from author where first_name = 'George R. R.' and last_name = 'Martin'));
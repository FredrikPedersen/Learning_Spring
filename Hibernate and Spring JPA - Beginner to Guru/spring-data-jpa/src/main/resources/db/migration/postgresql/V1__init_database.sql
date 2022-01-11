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
values ('9780765350374', 'Tor Books', 'Elantris', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('9780765311788', 'Tor Books', 'The Final Empire', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('9780765316882', 'Tor Books', 'The Well of Ascension', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('9780765316899', 'Tor Books', 'The Hero of Ages', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('9780765320308', 'Tor Books', 'Warbreaker', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('9780765326355', 'Tor Books', 'The Way of Kings', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('9780765326362', 'Tor Books', 'Words of Radiance', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('9780765326379', 'Tor Books', 'Oathbringer', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('0765326388', 'Tor Books', 'Rythm of War', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('9780765330420', 'Tor Books', 'The Alloy of Law', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('9780765378552', 'Tor Books', 'Shadows of Self', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));

insert into book (isbn, publisher, title, author_id)
values ('9780765378576', 'Tor Books', 'The Bands of Mourning', (select id from author where first_name = 'Brandon' and last_name = 'Sanderson'));


insert into author (first_name, last_name)
values ('J.R.R.', 'Tolkien');

insert into book (isbn, publisher, title, author_id)
values ('9780007136599', 'George Allen & Unwin', 'The Hobbit', (select id from author where first_name = 'J.R.R.' and last_name = 'Tolkien'));

insert into book (isbn, publisher, title, author_id)
values ('9780007136599', 'George Allen & Unwin', 'The Fellowship of the Ring', (select id from author where first_name = 'J.R.R.' and last_name = 'Tolkien'));

insert into book (isbn, publisher, title, author_id)
values ('9780007136599', 'George Allen & Unwin', 'The Two Towers', (select id from author where first_name = 'J.R.R.' and last_name = 'Tolkien'));

insert into book (isbn, publisher, title, author_id)
values ('9780007136599', 'George Allen & Unwin', 'The Return of the King', (select id from author where first_name = 'J.R.R.' and last_name = 'Tolkien'));

insert into book (isbn, publisher, title, author_id)
values ('9780007136599', 'George Allen & Unwin', 'The Adventures of Tom Bombadil', (select id from author where first_name = 'J.R.R.' and last_name = 'Tolkien'));

insert into book (isbn, publisher, title, author_id)
values ('9780007136599', 'George Allen & Unwin', 'The Silmarillion', (select id from author where first_name = 'J.R.R.' and last_name = 'Tolkien'));

insert into book (isbn, publisher, title, author_id)
values ('9780007136599', 'George Allen & Unwin', 'Unfinished Tales of Numenor and Middle-Earth', (select id from author where first_name = 'J.R.R.' and last_name = 'Tolkien'));

insert into book (isbn, publisher, title, author_id)
values ('9780007136599', 'George Allen & Unwin', 'The Children of Hurin', (select id from author where first_name = 'J.R.R.' and last_name = 'Tolkien'));

insert into book (isbn, publisher, title, author_id)
values ('9780007136599', 'George Allen & Unwin', 'Beren and Luthien', (select id from author where first_name = 'J.R.R.' and last_name = 'Tolkien'));

insert into author (first_name, last_name)
values ('George R. R.', 'Martin');

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'Voyager Books', 'A Game of Thrones', (select id from author where first_name = 'George R. R.' and last_name = 'Martin'));

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'Voyager Books', 'A Clash of Kings', (select id from author where first_name = 'George R. R.' and last_name = 'Martin'));

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'Voyager Books', 'A Storm of Swords', (select id from author where first_name = 'George R. R.' and last_name = 'Martin'));

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'Voyager Books', 'A Feast for Crows', (select id from author where first_name = 'George R. R.' and last_name = 'Martin'));

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'Voyager Books', 'A Dance With Dragons', (select id from author where first_name = 'George R. R.' and last_name = 'Martin'));

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'Voyager Books', 'The Winds of Winter', (select id from author where first_name = 'George R. R.' and last_name = 'Martin'));

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'Voyager Books', 'A Dream of Spring', (select id from author where first_name = 'George R. R.' and last_name = 'Martin'));

insert into author (first_name, last_name)
values ('Patrick', 'Rothfuss');

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'DAW Books', 'The Name of the Wind', (select id from author where first_name = 'Patrick' and last_name = 'Rothfuss'));

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'DAW Books', 'The Wise Man''s Fear', (select id from author where first_name = 'Patrick' and last_name = 'Rothfuss'));

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'DAW Books', 'The Doors of Stone', (select id from author where first_name = 'Patrick' and last_name = 'Rothfuss'));

insert into book (isbn, publisher, title, author_id)
values ('0-00-224584-1', 'DAW Books', 'The Slow Regard of Silent Things', (select id from author where first_name = 'Patrick' and last_name = 'Rothfuss'));




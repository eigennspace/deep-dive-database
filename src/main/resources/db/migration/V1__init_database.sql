drop table if exists book;
drop SEQUENCE if exists hibernate_sequence;
create table book(
    id bigint not null,
    isbn varchar(255),
    publisher varchar(255),
    title varchar(255),
    primary key (id)
);

CREATE SEQUENCE hibernate_sequence;
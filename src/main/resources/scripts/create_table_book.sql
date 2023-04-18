drop table if exists book;
drop sequence if exists hibernate_sequence;
create table book(
                     id bigint not null,
                     isbn varchar(255),
                     publisher varchar(255),
                     title varchar(255),
                     primary key (id)
);

CREATE SEQUENCE hibernate_sequence;
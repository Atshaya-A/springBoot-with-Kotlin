create schema if not exists todos;

create table if not exists todos
(
    id text not null primary key,
    title text ,
    description text,
    priority text
);
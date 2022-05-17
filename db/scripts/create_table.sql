create table post(
    id serial primary key,
    name text,
    text text,
    link text NOT NULL unique,
    created timestamp
);
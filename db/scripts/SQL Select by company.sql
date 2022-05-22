CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values(1, 'A');
insert into company(id, name) values(2, 'B');
insert into company(id, name) values(3, 'C');
insert into company(id, name) values(4, 'D');
insert into company(id, name) values(5, 'E');
insert into company(id, name) values(6, 'F');

insert into person(id, name, company_id) values(1, 'Pavel', 1);
insert into person(id, name, company_id) values(2, 'Olga', 1);
insert into person(id, name, company_id) values(3, 'Petr', 1);
insert into person(id, name, company_id) values(4, 'Nina', 2);
insert into person(id, name, company_id) values(5, 'Ilya', 2);
insert into person(id, name, company_id) values(6, 'Platon', 3);
insert into person(id, name, company_id) values(7, 'Andrey', 3);
insert into person(id, name, company_id) values(8, 'Sergey', 3);
insert into person(id, name, company_id) values(9, 'Varya', 3);
insert into person(id, name, company_id) values(10, 'Vika', 4);
insert into person(id, name, company_id) values(11, 'Sveta', 4);
insert into person(id, name, company_id) values(12, 'Anton', 4);
insert into person(id, name, company_id) values(13, 'Tanya', 5);
insert into person(id, name, company_id) values(14, 'Semen', 5);
insert into person(id, name, company_id) values(15, 'Sasha', 5);
insert into person(id, name, company_id) values(16, 'Vasya', 6);
insert into person(id, name, company_id) values(17, 'Grisha', 6);
insert into person(id, name, company_id) values(18, 'Stepa', 6);
insert into person(id, name, company_id) values(19, 'Anna', 6);

select p.name, c.name from person as p
join company as c
on p.company_id = c.id
where p.company_id != 5;

select c.name, count(p.id)
from company as c
join person as p
on p.company_id = c.id
group by c.name
having count(*) = (select 
count(p.company_id) as cc
from person as p
group by p.company_id
order by cc desc
limit 1);
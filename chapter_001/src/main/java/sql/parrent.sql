create table parrent(
	id serial primary key,
	age int,
	name varchar(100)
);

create table children(
	id serial primary key,
	name varchar(100),
	age int,
	parrent_id int references parrent(id)
);

insert into parrent(name, age) values('PARRENT%0', 10);
insert into parrent(name, age) values('PARRENT%1', 20);
insert into parrent(name, age) values('PARRENT%2', 30);
insert into parrent(name, age) values('PARRENT%3', 40);
insert into parrent(name, age) values('PARRENT%4', 50);
insert into parrent(name, age) values('PARRENT%5', 60);

insert into children(name, age, parrent_id) values('CHILDREN%0', 11, 1);
insert into children(name, age, parrent_id) values('CHILDREN%1', 22, 2);
insert into children(name, age, parrent_id) values('CHILDREN%2', 33, 3);
insert into children(name, age, parrent_id) values('CHILDREN%3', 44, 4);
insert into children(name, age, parrent_id) values('CHILDREN%4', 55, 5);
insert into children(name, age, parrent_id) values('CHILDREN%5', 66, 6);

select p.name, c.name from children as c join parrent as p on c.parrent_id = p.id;
select p.age as age_test, c.name as name_test from children as c join parrent as p on c.parrent_id = p.id;
select p.name name_new_test, c.age age_new_test from children as c join parrent as p on c.parrent_id = p.id;
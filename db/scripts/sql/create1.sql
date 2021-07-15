create table rules(
	id serial primary key,
	name varchar(100)
);

create table attachs(
	id serial primary key,
	name varchar(100)
);

create table category(
	id serial primary key,
	name varchar(100)
);

create table item(
	id serial primary key,
	name varchar(100),
	attach_id int references attachs(id),
	category_id int references category(id)
);

create table comments(
	id serial primary key,
	name varchar(100),
	item_id int references item(id)
);

create table users(
	id serial primary key,
	name varchar(100),
	item_id int references item(id)
);

create table role(
	id serial primary key,
	name varchar(100),
	user_id int references users(id)
);

create table state(
	id serial primary key,
	name varchar(100),
	item_id int references item(id)
);

create table roles_rules(
	id serial primary key,
	role_id int references role(id),
	rule_id int references rules(id)
);
insert into devices(name, price) values('Lenovo Legion Y520 15IKBN', 56990);
insert into devices(name, price) values('MSI GE73', 74990);
insert into devices(name, price) values('Acer PREDDATOR 21X', 699990);
insert into devices(name, price) values('ASUS ROG Strix SCAR 15s', 159990);
insert into devices(name, price) values('Razer DeatgAdder', 5990);
insert into devices(name, price) values('ASUS ROG Gladius 2', 4990);
insert into devices(name, price) values('steelseries qsk+', 1990);
insert into devices(name, price) values('steelseries rival', 7990);

insert into people(name) values('Bogdan');
insert into people(name) values('Petr');
insert into people(name) values('Stas');
insert into people(name) values('Andrey');

insert into devices_people(device_id, people_id) values(36, 17);
insert into devices_people(device_id, people_id) values(41, 17);
insert into devices_people(device_id, people_id) values(42, 17);
insert into devices_people(device_id, people_id) values(38, 18);
insert into devices_people(device_id, people_id) values(43, 18);
insert into devices_people(device_id, people_id) values(37, 19);
insert into devices_people(device_id, people_id) values(43, 19);
insert into devices_people(device_id, people_id) values(39, 19);
insert into devices_people(device_id, people_id) values(40, 19);
insert into devices_people(device_id, people_id) values(38, 20);

select avg(d.price) from devices d;

select s.name, avg(d.price) from devices_people as ss join people s on ss.people_id = s.id join devices d on ss.device_id = d.id
group by s.name;

select s.name, avg(d.price) from devices_people as ss join people s on ss.people_id = s.id join devices d on ss.device_id = d.id
group by s.name having avg(d.price) > 5000;
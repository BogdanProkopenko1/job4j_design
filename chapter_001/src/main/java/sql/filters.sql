select * from product p join type t on t.name = 'СЫР' and p.type_id = t.id;

select * from product p where p.name like '%мороженное%'

select * from product p where extract(month from p.expired_date) = extract(month from current_date + interval '1 month') and extract(year from p.expired_date) = extract(year from current_date + interval '1 month');

select * from product where price = (select max(price) from product)

select t.name as ТИП, count(*) as КОЛИЧЕСТВО from product p join type t on t.id = p.type_id group by t.name

select * from product p join type t on (t.name = 'СЫР' or t.name = 'МОЛОКО') and p.type_id = t.id;

select
	t.name as ТИП, count(*)
from
	product p
join
	type t on t.id = p.type_id group by t.name
having
	(select count(*) from product p join type t on t.id = p.type_id) < 10

select p.*, t.name as ТИП from product p join type t on p.type_id = t.id
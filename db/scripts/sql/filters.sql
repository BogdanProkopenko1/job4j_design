select * from product p join type t on p.type_id = t.id where t.name = 'СЫР';

select * from product p where p.name like '%мороженное%'

select
	*
from
	product p
where
	date_part('month', expired_date) = date_part('month', now() + interval '1 month');

select * from product where price = (select max(price) from product)

select t.name as ТИП, count(*) as КОЛИЧЕСТВО from product p join type t on t.id = p.type_id group by t.name

select * from product p join type t on p.type_id = t.id where t.name = 'СЫР' or t.name = 'МОЛОКО';

select
	t.name as ТИП, count(*)
from
	product p
join
	type t on t.id = p.type_id group by t.name having COUNT(*) < 10

select p.*, t.name as ТИП from product p join type t on p.type_id = t.id
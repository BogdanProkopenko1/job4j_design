select
	c.*, e.*, b.*, t.*
from
	car c
		left join engine e on c.engine_id = e.id
		left join body b on c.body_id = b.id
		left join transmission t on c.transmission_id = t.id

select
	e.*, b.*, t.*
from
	car c
		full join engine e on c.engine_id = e.id
		full join body b on c.body_id = b.id
		full join transmission t on c.transmission_id = t.id
			where (c.engine_id is null) or (c.body_id is null) or (c.transmission_id is null)
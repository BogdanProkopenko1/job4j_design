select * from departments d left join employees e on d.id = e.department_id

select * from departments d right join employees e on d.id = e.department_id

select * from departments d full join employees e on d.id = e.department_id

select * from departments cross join employees

select * from departments d left join employees e on d.id = e.department_id where e.department_id is null

select m, w from teens m cross join teens w where m.name != w.name;
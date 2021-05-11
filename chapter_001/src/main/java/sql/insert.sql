insert into rules(name) values('TESTrole');
insert into attachs(name) values('TESTattach');
insert into comments(name) values('TESTcomment');
insert into item(name, comment_id, attach_id) values('TESTitem', 1, 1);
insert into category(name, item_id) values('TESTcategory', 1);
insert into users(name, item_id) values('TESTuser', 1);
insert into role(name, user_id) values('TESTrole', 1);
insert into state(name, item_id) values ('TESTstate', 1);
insert into roles_rules(role_id, rule_id) values(1, 1);
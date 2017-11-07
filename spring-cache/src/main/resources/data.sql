-- user data
insert into user (id, username, name, age, balance) values (1, 'account1', '张三', 20, 100.00);
insert into user (id, username, name, age, balance) values (2, 'account2', '李四', 28, 180.00);
insert into user (id, username, name, age, balance) values (3, 'account3', '王五', 32, 280.00);

-- course data
insert into course values (1, '语文');
insert into course values (2, '数学');
insert into course values (3, '英文');


-- user_course data
insert into user_course values (1, 1, 1, 71);
insert into user_course values (1, 1, 2, 98);
insert into user_course values (1, 1, 3, 88);
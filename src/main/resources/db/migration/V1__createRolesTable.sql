create table roles(
id bigint(20) auto_increment,
role_name varchar(100) unique,
primary key(id)
);

insert into roles(role_name) value("Home");
insert into roles(role_name) value("Admin");
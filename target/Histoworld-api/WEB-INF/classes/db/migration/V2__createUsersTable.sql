create table users(
	id bigint(20) auto_increment,
	user_name varchar(200) unique,
	user_password varchar(400),
    primary key(id)
);

insert into users (user_name,user_password) values ("Admin","admin12345");
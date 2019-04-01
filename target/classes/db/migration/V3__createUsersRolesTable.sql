create table users_roles(
user_id bigint(20),
roles_id bigint(20),
primary key(user_id,roles_id)
);

ALTER TABLE users_roles
ADD CONSTRAINT userKey
FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE users_roles
ADD CONSTRAINT rolesKey
FOREIGN KEY (roles_id) REFERENCES roles(id);
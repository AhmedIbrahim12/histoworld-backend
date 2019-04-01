create table lecture(
id bigint(20) auto_increment,
title varchar(200),
description MEDIUMTEXT,
attachment_download_url MEDIUMTEXT,
primary key(id)
);
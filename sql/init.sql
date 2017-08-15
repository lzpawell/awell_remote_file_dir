create database awell_remote_file_dir;

use awell_remote_file_dir;


create table user(
	user_id varchar(20) primary key not null,
	password varchar(20) not null,
	nickname varchar(20) not null
);

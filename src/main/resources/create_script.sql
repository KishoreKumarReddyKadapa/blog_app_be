-- /*****
-- * Create Post Table
-- ****/
-- create table posts(
-- 	id INT AUTO_INCREMENT   NOT NULL,
-- 	title VARCHAR(100) NOT NULL,
-- 	description VARCHAR(1000)  NOT NULL,
-- 	content TEXT NOT NULL,
-- 	created_by VARCHAR(50),
-- 	created_dt DEFAULT CURRENT_TIMESTAMP ,
-- 	updated_by VARCHAR(50)
-- 	updated_dt TIMESTAMP ,
-- 	record_status VARCHAR(1),
-- 	primary key(id)
-- );

-- create table users(
-- 	id INT AUTO_INCREMENT   NOT NULL,
-- 	name VARCHAR(100) NOT NULL,
-- 	user_name VARCHAR(50)  NOT NULL,
-- 	email TEXT NOT NULL,
-- 	password varchar(250) NOT NULL,
-- 	created_by VARCHAR(50),
-- 	created_dt DEFAULT CURRENT_TIMESTAMP ,
-- 	updated_by VARCHAR(50)
-- 	updated_dt TIMESTAMP ,
-- 	record_status VARCHAR(1),
-- 	primary key(id)
-- );

-- insert into users(name,user_name,email,password)
-- values('sk','sk','sk@gmail.com','$2a$10$BBPfb36yHK9/tglLqaCzuOmMra0s3tXhgbSLZddHgJxQ87zxSNc6.')

-- create table roles(
-- 	id INT AUTO_INCREMENT   NOT NULL,
-- 	name VARCHAR(20) NOT NULL,
-- 	created_by VARCHAR(50),
-- 	created_dt DEFAULT CURRENT_TIMESTAMP ,
-- 	updated_by VARCHAR(50)
-- 	updated_dt TIMESTAMP ,
-- 	record_status VARCHAR(1),
-- 	primary key(id)
-- );
-- insert into roles(name)
-- values('ADMIN')

-- create table user_roles(
-- 	user_id INT,
-- 	role_id INT
-- )

-- insert into user_roles(user_id,role_id)
-- values(1,1)



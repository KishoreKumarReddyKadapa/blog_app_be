/*****
* Create Post Table
****/
create table posts(
	id INT AUTO_INCREMENT   NOT NULL,
	title VARCHAR(100) NOT NULL,
	description VARCHAR(1000)  NOT NULL,
	content TEXT NOT NULL,
	created_by VARCHAR(50),
	created_dt DEFAULT CURRENT_TIMESTAMP ,
	updated_by VARCHAR(50)
	updated_dt TIMESTAMP ,
	record_status VARCHAR(1),
	primary key(id)
)
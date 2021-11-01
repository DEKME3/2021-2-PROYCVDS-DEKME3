-- Create tables

-- Users Table
create table Users(
	id SERIAL not null,
	name VARCHAR(50) not null,
	password VARCHAR(20) not null,
	email VARCHAR(50) not null,
	status bit not null,
	UserType INT not NULL
);

-- UserTypes Table
create table UserTypes(
	id SERIAL not null,
	name VARCHAR(20) not null,
	description VARCHAR(50) not null,
	UNIQUE(name)
);
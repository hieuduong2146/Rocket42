create database DepartmentManagement;
Use DepartmentManagement ;
create table Department(
	id bigint not null auto_increment primary key,
    department_name nvarchar(50)
    
);

create table Positon(
	position_id bigint not null auto_increment primary key,
	PositionName nvarchar(50)
    
);
create table Account(
	account_id bigint not null auto_increment primary key,
	email nvarchar(50) unique,
    username nvarchar(50),
    fullname nvarchar(50),
    department_id bigint not null,
    foreign key(department_id) references Department(id),
    positionId bigint not null,
    foreign key(positionId) references positon(position_id),
    createDate date
);



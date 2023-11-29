create database DepartmentManagement;
Use DepartmentManagement ;
create table Department(
	DepartmentID bigint,
    DepartmentName nvarchar(50)
    
);

create table Positon(
	PositionID bigint,
	PositionName nvarchar(50)
    
);
create table Account(
	AccountID bigint,
	Email nvarchar(50),
    Username nvarchar(50),
    Fullname nvarchar(50),
    DeparmentID bigint,
    PositionID bigint,
    CreateDate date
);

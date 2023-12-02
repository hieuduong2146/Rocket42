create database DepartmentManagement;
Use DepartmentManagement ;
create table Department(
	id bigint not null auto_increment primary key,
    department_name nvarchar(50) not null
    
);

create table Positon(
	position_id bigint not null auto_increment primary key,
	PositionName nvarchar(50) not null
    
);
create table Account(
	account_id bigint not null auto_increment primary key,
	email nvarchar(50) unique,
    username nvarchar(50) not null,
    fullname nvarchar(50) not null,
    department_id bigint not null,
    foreign key(department_id) references Department(id),
    positionId bigint not null,
    foreign key(positionId) references positon(position_id),
    createDate date not null
);


create table `grounp`(
	grounp_id bigint not null auto_increment primary key,
	grount_name nvarchar(50) not null,
    creator_id bigint ,
    create_date date not null
);

create table grounpAcount(
	grounpId bigint not null, foreign key(grounpId) references grounp(grounp_id),
	accountId bigint not null, foreign key(accountId) references Account(account_id),
    joinDate date not null
);

create table typeQuestion(
	type_id bigint not null auto_increment primary key,
	type_name nvarchar(50) not null
);

create table categoryQuestion(
	category_id bigint not null auto_increment primary key,
	category_name nvarchar(50) not null
);

create table Question(
	question_id bigint not null auto_increment primary key,
	content text,
    categoryId bigint not null, foreign key(categoryId) references categoryQuestion(category_id),
    typeId bigint not null, foreign key(typeId) references typeQuestion(type_id),
    createDate date not null
);


create table Answer(
	answer_ID bigint not null auto_increment primary key,
    content text ,
    questionId  bigint not null, foreign key(questionId) references Question(question_id),
	isCrorect nvarchar(50) not null
);

create table Exam(
	exam_id bigint not null auto_increment primary key,
    code_exam nvarchar(50) not null ,
	title nvarchar(50) not null,
    categoryId bigint not null, foreign key(categoryId) references categoryQuestion(category_id),
    duration bigint not null,
    createDate date not null
);
create table examQuestion(
	examId bigint not null, foreign key(examId) references Exam(exam_id),
   questionId bigint not null, foreign key(questionId) references Question(question_id)
);





alter table  Account
change column email email nvarchar(50) unique;
insert into Department(department_name) values ('Marketing'),('sale'),('Bảo vệ'),('nhân sự'),('Kỹ thuật'),('Tài chính'),('Phó giám đốc'),('Giám đốc'),('Thư Kí'),('Bán hàng');
insert into Department(department_name) values ('CNTT');
select * from Department;
insert into Positon(PositionName) values ('Dev'),('Manager'),('Leader '),('CEO'),('CFO'),('CMO');
insert into Positon(PositionName) values ('Staff');
select * from Positon;
insert into Account (email,username,fullname,department_id,positionId,createDate) values ('hieuduong@','Hieu','Duong','11','7',now());
insert into Account (email,username,fullname,department_id,positionId,createDate) values ('Quanduong@','Quan','Duong','11','7',now())
,('huyny@','ny','Huynh','1','3',now()),('QuyenHoang@','Quyen','Hoang','2','2',now()),('PhuongDuong@','Phuong','Duong','10','7',now());
select * from Account;
insert into `grounp`(grount_name,creator_id,create_date) values ('Rocket42',1,now()),('Rocket43',1,now()),('Rocket44',1,now()),('Rocket45',1,now());
select * from `grounp`;
insert into grounpAcount (grounpId,accountId,joinDate) values(1,3,now()),(1,4,now()),(2,1,now()),(3,3,now()),(4,4,now());
select * from grounpAcount;
insert into typequestion(type_name) values ('essay'),('Multiple-Choice)');
select * from typequestion;
insert into categoryQuestion(category_name) values ('Java'),('.NET'),('SQL'),('Postman'),('Ruby');
select * from categoryQuestion;
insert into question(content,categoryId,typeId,createDate) values ('Hôm nay bạn thấy thế nào?',1,1,now()), ('Bạn ăn cơm chưa?',2,1,now()),('Bạn có thích chơi thể thao không?',3,1,now()),
('Tại sao bạn lại chọn công việc này?',4,2,now()),('Bạn cảm thấy phù hợp với vị trí nào?',5,2,now());
insert into Answer(content,questionId,isCrorect) values('Yêu đời','1','Yes'),('Tôi ăn rồi','2','Yes'),('Có','3','Yes'),('Tôi yêu công việc này','4','Yes'),('Leader','5','Yes');
select * from Answer;
alter table  Exam
add constraint check_duration check (duration = 45 );
insert into exam(code_exam,title,categoryId,duration,createDate) values ('A1','Bầu trời xanh',1,45,now()),('A2','Bầu trời xanh',2,45,now()),('A3','Bầu trời xanh',3,45,now()),
('A4','Bầu trời xanh',4,45,now()),('A5','Bầu trời xanh',5,45,now());
select * from exam;
insert into examQuestion(examId,questionId) values (2,3),(3,4),(1,2),(5,5),(4,1);
select * from examQuestion;
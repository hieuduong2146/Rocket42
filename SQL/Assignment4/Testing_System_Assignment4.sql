create database DerpartmentManagement;
Use DerpartmentManagement ;
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

CREATE TABLE Staff(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	staff_code NVARCHAR(64) NOT NULL UNIQUE,
	staff_name NVARCHAR(64) NOT NULL,
	email VARCHAR(32) UNIQUE,
	gender ENUM('Male', 'Female', 'Unknown'),
    salary INT,
	department_id BIGINT NOT NULL,
	positionId BIGINT NOT NULL,
	created_date DATE,
	FOREIGN KEY (department_id) REFERENCES Department(id),
	FOREIGN KEY (positionId) REFERENCES `Positon`(position_id)
);
CREATE TABLE GroupMember(
	group_id BIGINT NOT NULL,
	account_id BIGINT,
	joined_date DATE,
	FOREIGN KEY (group_id) REFERENCES `Grounp`(grounp_id),
	FOREIGN KEY (account_id) REFERENCES Account(account_id)
);
INSERT INTO GroupMember 
VALUES (1, 1, CURDATE()), (1, 2, CURDATE()),
(2, 1, CURDATE()), (2, 2, CURDATE()),
(2, 3, CURDATE()), (2, 4, CURDATE());
select * from GroupMember;
INSERT INTO Staff(staff_code, staff_name, email, gender, department_id, positionId, created_date, salary)
VALUES ('staff01', 'Axx Bxx Cxx', 'staff01@gmail.com', 'Male', 1, 1, CURDATE(), 12000),
('staff02', 'Le Bxx Cxx', 'staff02@yahoo.com', 'Female', 3, 1, CURDATE(), 13000),
('staff03', 'Le Bxx Cxx', 'staff03@email.com', 'Female', 3, 1, NULL, 14000),
('staff04', 'Le Bxx Cxx', 'staff04@gmail.com', 'Male', 3, 2, '2022-07-09', 15000);


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
insert into Account (email,username,fullname,department_id,positionId,createDate) values ('thoDuong@','Tho','Duong','11','7',now());
select * from Account;
insert into `grounp`(grount_name,creator_id,create_date) values ('Rocket42',1,now()),('Rocket43',1,now()),('Rocket44',1,now()),('Rocket45',1,now());
insert into `grounp`(grount_name,creator_id,create_date) values ('Rocket47',1,'2019-12-18'),('Rocket47',1,'2019-12-15');
select * from `grounp`;
insert into grounpAcount (grounpId,accountId,joinDate) values(1,3,now()),(1,4,now()),(2,1,now()),(3,3,now()),(4,4,now());
select * from grounpAcount;
insert into typequestion(type_name) values ('essay'),('Multiple-Choice)');
select * from typequestion;
insert into categoryQuestion(category_name) values ('Java'),('.NET'),('SQL'),('Postman'),('Ruby');
select * from categoryQuestion;
insert into question(content,categoryId,typeId,createDate) values ('Hôm nay bạn thấy thế nào?',1,1,now()), ('Bạn ăn cơm chưa?',2,1,now()),('Bạn có thích chơi thể thao không?',3,1,now()),
('Tại sao bạn lại chọn công việc này?',4,2,now()),('Bạn cảm thấy phù hợp với vị trí nào?',5,2,now());
insert into question(content,categoryId,typeId,createDate) values ('Câu hỏi của bạn là?',5,1,now());
insert into question(content,categoryId,typeId,createDate) values ('Câu hỏi của bạn là?',1,1,now()),('Câu hỏi như sau',1,1,now());
insert into Answer(content,questionId,isCrorect) values('Yêu đời','1','Yes'),('Tôi ăn rồi','2','Yes'),('Có','3','Yes'),('Tôi yêu công việc này','4','Yes'),('Leader','5','Yes');
insert into Answer(content,questionId,isCrorect) values('Yêu đờii','1','Yes'),('Yêu đờiii','1','Yes'),('Yêu đờiii','1','Yes'),('Yêu đờiii','1','Yes');
select * from question;
alter table  Exam
add constraint check_duration check (duration = 80 );
insert into exam(code_exam,title,categoryId,duration,createDate) values ('A1','Bầu trời xanh',1,45,now()),('A2','Bầu trời xanh',2,45,now()),('A3','Bầu trời xanh',3,45,now()),
('A4','Bầu trời xanh',4,45,now()),('A5','Bầu trời xanh',5,45,now());
insert into exam(code_exam,title,categoryId,duration,createDate) values ('A7','Bầu trời xanh',1,65,'2019-12-15'),('8','Bầu trời xanh',1,70,'2019-12-18');
select * from exam;
insert into examQuestion(examId,questionId) values (2,3),(3,4),(1,2),(5,5),(4,1);
select * from examQuestion;
select * from Account  where createDate is not null;
select * from Account  where createDate is null;
select count( distinct account_id) from Account;
select max(account_id) from Account;
select min(account_id) from Account;
select Q.question_id from question as Q inner join answer as A on question_id = questionId;
update grounp set grount_name = 'Rocket48' where grounp_id = 6;


select * from department;
select id from department where department_name = 'Sale';
select grount_name from `grounp` where create_date < '2019-12-20';
SELECT * FROM Account WHERE LENGTH(fullname) = (SELECT MAX(LENGTH(fullname)) FROM Account);
SELECT * FROM Account
WHERE LENGTH(fullname) = (SELECT MAX(LENGTH(fullname)) FROM Account) AND department_id = 2;
select code_exam from exam where duration >= 60 and  createDate < '2019-12-20';
select * from grounp order by create_date desc limit 5;
select count(*) as SoNhanVien from account where department_id = 2;
select * from account where username like 'D%o';
delete from exam where createDate < '2019-12-20';
delete from question where content like 'câu hỏi%';
update account set fullname = 'Nguyễn Bá Lộc' , email ='loc.nguyenba@vti.com.vn' where account_id = '5';
SELECT questionId,count(content) as numberOfAnswer FROM Answer group by questionId having numberOfAnswer > 4   ;
update `Account` set grounp_id = 4 where account_id = 5;

-- Assignment4 -- 

#1
select a.account_id,a.email,a.username,a.fullname,p.positionName from account as a inner join positon as p on a.positionId = p.position_id;
#2
select * from `account` where  createDate > '2010-12-20';
#3
select a.account_id,a.email,a.username,a.fullname,p.positionName from account as a inner join positon as p on a.positionId = p.position_id where p.positionName = 'dev';
#4
select p.positionName,count(p.positionName) as soNhanVien from account as a inner join positon as p on a.positionId = p.position_id group by p.positionName having soNhanVien > 3 ;
#5
select q.question_id,q.content,count(eq.examId) as inExam from question as q inner join  examquestion as eq on q.question_id = eq.questionId group by q.question_id,q.content order by inExam desc ;
select * from question;
#6
select cq.category_name ,count(q.question_id)  from categoryQuestion as cq inner join question as q on cq.category_id = q.categoryId group by cq.category_name;
#7
select q.content,count(e.exam_id) as soBaiThi from question as q inner join exam as e on q.question_id = e.exam_id group by q.content ;
#8 

select  q.content,count(a.answer_ID) soCauTraLoi from question as q inner join answer as a on q.question_id = a.questionId group by   q.content order by soCauTraLoi desc limit 1 ;
#9
select grount_name,count(creator_id) soNhanVien from `grounp` as a  group by  grount_name ;
#10
select p.position_id,p.PositionName,count(s.positionId) soChucVu from positon as p inner join staff as s on p.position_id = s.positionId group by p.position_id,p.PositionName  order by soChucVu asc limit 1;
#11
select *from `account`;
select d.department_name,p.PositionName,count(a.account_id) from department as d  inner join `account` as a on  d.id = a.department_id inner join positon as p on a.positionId = p.position_id group by d.id,p.position_id;
#12
select q.question_id,q.content,t.type_name,a.content from question as q inner join  typequestion as t on q.typeId = t.type_id inner join answer as a on a.questionId = q.question_id ;
#13
select t.type_name , count(q.question_id) from Question as q inner join typeQuestion as t on q.typeId = t.type_id group by t.type_name ;
#14
select * from `grounp` as g left join groupMember as gm on g.grounp_id = gm.group_id where gm.account_id is null;
#15
select * from account;
select * from question as q left join answer as a on q.question_id = a.questionId where a.content is null;

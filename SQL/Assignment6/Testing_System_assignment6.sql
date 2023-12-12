#Assigntment6
#1
drop procedure if exists getAccout;
DELIMITER $$
create procedure getAccout(in `name` nvarchar(50))
begin
	 Select a.account_id,a.email,a.username,a.fullname,d.department_name 
    from `account` as a inner join department as d on a.department_id = d.id
    where d.department_name  = `name`;
end$$
DELIMITER ;
call getAccout('Sale');

#2
drop procedure if exists getNumberAccout;
DELIMITER $$
create procedure getNumberAccout()
begin
	select group_id,count(account_id) numberAccount from groupMember group by group_id;
end$$
DELIMITER ;
call getNumberAccout();

#3
drop procedure if exists getTypeQuestion;
DELIMITER $$
create procedure getTypeQuestion()
begin
	select tq.type_id,tq.type_name,count(tq.type_id) from typequestion as 
	tq inner join question as q on tq.type_id = q.typeId where createDAte > '2023-12-01' And 
	createDAte < '2023-12-31' group by tq.type_name,tq.type_id ;
end$$
DELIMITER ;
call getTypeQuestion();

#4

drop procedure if exists getNumberQuestion;
DELIMITER $$
create procedure getNumberQuestion()

begin
	select q.typeId,tq.type_name,count(q.question_id) As NumberQuestion from typequestion as 
	tq inner join question as q on tq.type_id = q.typeId group by q.typeId,tq.type_name 
    having NumberQuestion = (Select max(numberMax) from (select count(question_id) as numberMax from question group by typeId) q) ;
end$$
DELIMITER ;
call getNumberQuestion();

#5
drop procedure if exists getNameType;
DELIMITER $$
create procedure getNameType(in id bigint,out user_name_out nvarchar(50))
begin
	select type_name into user_name_out from typequestion as tq inner join
    question as q on tq.type_id = q.typeId where q.question_id = id;
end $$
DELIMITER ;
call getNameType(4,@type_name);
select @type_name;
#6

drop procedure if exists getNameGroup;
DELIMITER $$
create procedure getNameGroup(p_keyword  nvarchar(10))
begin
	select grounp_id,grount_name from grounp 
    where grount_name like concat('%',p_keyword,'%');
end $$
DELIMITER ;
call getNameGroup('42');
#7
#8
drop procedure if exists getMaxContent;
DELIMITER $$
create procedure getMaxContent(in name_type nvarchar(60))
begin
	select t.type_name,t.type_id,q.content from question as q
    inner join typequestion as t
	where t.type_name = name_type    
	order by LENGTH(content) desc
	limit 1;
end $$
DELIMITER ;
call getMaxContent('essay');
#9
drop procedure if exists getDelete;
DELIMITER $$
create procedure getDelete(in id bigint)
begin
	delete from Exam where exam_id = id ;
end $$
DELIMITER ;
call getDelete(1);
select * from exam
#10 
#11
#12
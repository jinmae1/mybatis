--=====================================================
-- hello-mybatis
--=====================================================
-- student table생성
create table student(
    no number,
    name varchar2(50) not null,
    tel char(11) not null,
    reg_date date default sysdate,
    constraint pk_student_no primary key(no)
);

create sequence seq_student_no;

insert into 
    student(no, name, tel)
values(
    seq_student_no.nextval,
    '홍길동',
    '01012341234'
);

select * from student;

--============================================
-- web계정에서 kh계정의 일부테이블 사용하기
--============================================
select * from kh.employee;
select * from kh.department;
select * from kh.job;

-- kh계정 권한부여
grant all on kh.employee to ot1b;
grant select on kh.department to ot1b;
grant select on kh.job to ot1b;

-- synonym 동의어객체
-- 별칭객체
-- create synonym은 resource 롤에 포함되지 않는 권한이기 때문에 관리자를 통해 권한부여
create synonym emp for kh.employee;
create synonym dept for kh.department;
create synonym job for jh.job;

-- system계정
grant create synonym to ot1b;
-- 현재 공용db 사용중이라 create synonym 사용 불가

select 
			*
		from (
			select
				kh.employee.*,
				(select job_name from kh.job where job_code = kh.employee.job_code) job_name,
				(select dept_title from kh.department where dept_id = kh.employee.dept_code) dept_title,
				decode(substr(emp_no, 8, 1), '1', '남', '3', '남', '여') gender
			from
				kh.employee
		);
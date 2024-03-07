-- Create a Empl table 	

create table if not exists Empl(
     empno int primary key,
     ename varchar(30),
     job varchar(30),
     mgr int,
     hiredate date,
     sal decimal(10,2),
     comm float(10,2),
     deptno int not null
);

-- Store the given employee details inside the Empl Table

insert into empl VALUES 
(8369,'SMITH','CLERK',8902,'1990-12-18',800.00,NULL,20),
(8499,'ANYA','SALESMAN',8698,'1991-02-20',1600.00,00.00,30),
(8521,'SETH','SALESMAN',8698,'1991-02-22',1250.00,500.00,30),
(8566,'MAHADEVAN','MANAGER',8839,'1991-04-02',2985.00,NULL,20),
(8654,'MOMIN','SALESMAN',8698,'1991-09-28',1250.00,1400.00,30),
(8698,'BINA','MANAGER',8839,'1991-05-01',2850.00,NULL,30),
(8839,'AMIR','PRESIDENT',NULL,'1991-11-18',1500.00,NULL,10),
(8844,'KULDEEP','SALESMAN',8698,'1991-09-08',1500.00,0.00,30),
(8882,'SHIAVNSH','MANAGER',8839,'1991-06-09',2450.00,NULL,10),
(8886,'ANUB','CLERK',8888,'1993-01-12',1100.00,NULL,20),
(8888,'SCOTT','ANALYST',8566,'1992-12-09',3000.00,NULL,20),
(8900,'JATIN','CLERK',8698,'1991-12-03',950.00,NULL,30),
(8902,'FAKIR','ANALYST',8566,'1991-12-03',3000.00,NULL,20),
(8934,'MITA','CLERK',8882,'1992-01-23',1300.00,NULL,10);

-- Display the values in Empl Table

SELECT * FROM Empl;

-- Display EName and Sal of employees whose salary are greater than or equal to 2200

SELECT empno, sal FROM Empl WHERE sal >= 2200;
 
-- Display details of employees who are not getting commission

SELECT * FROM Empl WHERE comm is NULL;

-- Display employee name and salary of those employees who don't have their salary in the range of 2500 to 4000

SELECT ename,sal FROM Empl WHERE sal NOT BETWEEN 2500 AND 4000;

-- Display the name, job title and salary of employees who don't have a manager

SELECT ename,job,sal FROM Empl WHERE mgr IS NULL;

-- Display the name of an employee whose name contains "A" as third alphabet

SELECT ename FROM Empl WHERE ename LIKE '__A%';

-- Display the name of an employee whose name contains "T" as the last alphabet

SELECT ename FROM Empl WHERE ename LIKE '%T';


CREATE DATABASE BTVN;
CREATE TABLE Test(
testID INT PRIMARY KEY,
name VARCHAR(255)
);
CREATE TABLE Student(
RN INT PRIMARY KEY,
name VARCHAR(255),
age int,
status VARCHAR(255)
);
CREATE TABLE StudentTest(
RN_Student INT,
FOREIGN KEY(RN_Student) REFERENCES student(RN),
TestID_Test INT,
FOREIGN KEY(TestID_Test) REFERENCES Test(TestID),
date DATE,
mark FLOAT
);
INSERT INTO `btvn`.`student` (`RN`, `name`, `age`) VALUES ('1', 'Nguyen Hong Ha', '20');
INSERT INTO `btvn`.`student` (`RN`, `name`, `age`) VALUES ('2', 'Truong Ngoc Anh', '30');
INSERT INTO `btvn`.`student` (`RN`, `name`, `age`) VALUES ('3', 'Tuan Minh', '25');
INSERT INTO `btvn`.`student` (`RN`, `name`, `age`) VALUES ('4', 'Dan Truong', '22');

INSERT INTO `btvn`.`test` (`testID`, `name`) VALUES ('1', 'EPC');
INSERT INTO `btvn`.`test` (`testID`, `name`) VALUES ('2', 'DWMX');
INSERT INTO `btvn`.`test` (`testID`, `name`) VALUES ('3', 'SQL1');
INSERT INTO `btvn`.`test` (`testID`, `name`) VALUES ('4', 'SQL2');

insert into studenttest value (1,1,'2006-7-17',8);
insert into studenttest value (1,2,'2006-7-18',5);
insert into studenttest value (1,3,'2006-7-19',7);
insert into studenttest value (2,1,'2006-7-17',7);
insert into studenttest value (2,2,'2006-7-18',4);
insert into studenttest value (2,3,'2006-7-19',2);
insert into studenttest value (3,1,'2006-7-17',10);
insert into studenttest value (3,3,'2006-7-18',1);

-- 2.Hiển thị danh sách các học viên đã tham gia thi, các môn thi được thi bởi các học viên đó, điểm thi và ngày thi giống như hình sau:

SELECT student.name as StudentName ,test.name as TestName, studenttest.mark,studenttest.date
FROM studenttest 
JOIN student ON studenttest.RN_Student = student.RN
JOIN test ON studenttest.TestID_Test = test.testID;

-- 3.Hiển thị danh sách các bạn học viên chưa thi môn nào như hình sau:
SELECT student.*
FROM StudentTest as st
RIGHT JOIN student on st.RN_Student=student.RN
WHERE mark is Null;

-- 4. Hiển thị danh sách học viên phải thi lại, tên môn học phải thi lại và điểm thi(điểm phải thi lại là điểm nhỏ hơn 5) như sau:
SELECT student.name as 'Student Name',test.name as 'Test Name', studenttest.mark, studenttest.date
FROM studenttest
JOIN student on studenttest.RN_Student = student.RN
JOIN test ON studenttest.TestID_Test = test.testID
WHERE mark < 5;

-- 5. Hiển thị danh sách học viên và điểm trung bình(Average) của các môn đã thi. Danh sách phải sắp xếp theo thứ tự điểm trung bình giảm dần(nếu không sắp xếp thì chỉ được ½ số điểm) như sau:
SELECT student.name as 'Student Name ' , AVG(mark) as 'diemtrungbinh'
FROM student
JOIN studenttest on studenttest.RN_Student = student.RN
GROUP BY student.RN
ORDER BY diemtrungbinh DESC;

-- 6.Hiển thị tên và điểm trung bình của học viên có điểm trung bình lớn nhất như sau:
SELECT student.name as 'Student Name ' , AVG(mark) as 'diemtrungbinh'
FROM student
JOIN studenttest on studenttest.RN_Student = student.RN
GROUP BY student.RN
HAVING diemtrungbinh = (SELECT AVG
(studenttest.mark) 
FROM studenttest group by studenttest.RN_Student);

CREATE DATABASE DemoTrigger;
CREATE TABLE Student(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255),
age VARCHAR(255),
nameClass VARCHAR(255),
FOREIGN KEY (nameClass) REFERENCES class(nameClass) 
);
CREATE TABLE Class(
nameClass VARCHAR(255) PRIMARY KEY,
idClass INT ,
idStudent INT,
soluonghocsinh INT 
);
DROP TABLE student;
DROP TABLE Class;

delimiter //
CREATE TRIGGER insert_id_from_Student
AFTER INSERT 
ON student  FOR EACH ROW
BEGIN
    
     UPDATE `demotrigger`.`class` SET `soluonghocsinh` = class.soluonghocsinh+1 WHERE (`nameClass` = New.nameclass);

END //
delimiter ;
drop TRIGGER insert_id_from_Student;

INSERT INTO student ( id, age, name,nameclass) 
VALUES 
(2,21,'ta','c09'),
(1,20,'tan','c09'),
(3,22,'yen','c09');


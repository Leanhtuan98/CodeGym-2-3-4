CREATE DATABASE QuanLySinhVien;
USE QuanLySinhVien;
-- Tạo bảng class--
CREATE TABLE Class(
ClassID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
ClassName VARCHAR(30) NOT NULL,
StartDate DATETIME NOT NULL,
Status BIT

);
-- Tạo bảng học sinh với khóa ngoại là ClassId, phụ thuộc vào ID của Class --
CREATE TABLE Student(
StudentId INT NOT NULL AUTO_INCREMENT KEY,
StudentName VARCHAR(30) NOT NULL,
Address VARCHAR(30),
Phone VARCHAR(20),
Status BIT,
ClassId INT NOT NULL,
FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);
-- Tạo Bảng môn học --
CREATE TABLE Subject(
SubId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
SubName VARCHAR(30),
Credit TINYINT NOT NULL DEFAULT 1 CHECK (credit >= 1),
Status BIT
);
-- Tạo bảng thời khóa biểu -- 
CREATE TABLE Mark (
MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);
INSERT INTO Class VALUES (1, 'A1', '2020-12-14',1);
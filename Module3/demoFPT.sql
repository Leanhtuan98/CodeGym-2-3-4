CREATE DATABASE QuanLyXe;
CREATE TABLE NhaCungCap(
MaNhaCC VARCHAR(255) NOT NULL PRIMARY KEY,
TenNhaCC VARCHAR(255),
DiaChi VARCHAR (255),
SoDT CHAR(10),
MaSoThue VARCHAR (50)
);

CREATE TABLE LoaiDichVu(
MaLoaiDV VARCHAR(255) NOT NULL PRIMARY KEY,
TenLoaiDichVu VARCHAR(255)
);

CREATE TABLE MucPhi(
MaMP VARCHAR(255) NOT NULL PRIMARY KEY,
DonGia INT,
MoTa LONGTEXT
);
-- DROP TABLE MucPhi;

CREATE TABLE DongXe(
DongXe VARCHAR(255) NOT NULL PRIMARY KEY,
HangXe VARCHAR(255),
SoChoNgoi CHAR
);

CREATE TABLE DangKyCungCap(
MaDangKyCungCap VARCHAR(255)  PRIMARY KEY,
MaNhaCC VARCHAR(255),
FOREIGN KEY(MaNhaCC) REFERENCES NhaCungCap(MaNhaCC),
MaLoaiDV VARCHAR(255),
FOREIGN KEY(MaLoaiDV) REFERENCES LoaiDichVu(MaLoaiDV),
MaMP VARCHAR(255),
FOREIGN KEY(MaMP) REFERENCES MucPhi(MaMP),
DongXe VARCHAR(255),
FOREIGN KEY(DongXe) REFERENCES DongXe(DongXe),
NgayBatDauCungCap DATE,
NgayKetThucCungCap DATE,
SoLuongXeDangKy INT
);

-- Câu 3: Liệt kê những dòng xe có số chỗ ngồi trên 5 chỗ

SELECT * FROM dongxe 
WHERE SoChoNgoi >= 5;

-- Câu 4: Liệt kê thông tin của các nhà cung cấp đã từng đăng ký cung cấp những dòng xe
-- thuộc hãng xe “Toyota” với mức phí có đơn giá là 15.000 VNĐ/km hoặc những dòng xe
-- thuộc hãng xe “KIA” với mức phí có đơn giá là 20.000 VNĐ/km

SELECT *
FROM DangKyCungCap;

SELECT *
FROM DongXe;

SELECT * 
FROM loaidichvu;


INSERT INTO `quanlyxe`.`dangkycungcap` (`MaDangKyCungCap`, `MaNhaCC`, `MaLoaiDV`, `MaMP`, `DongXe`, `NgayBatDauCungCap`, `NgayKetThucCungCap`, `SoLuongXeDangKy`) VALUES ('CCDV1', 'A1', '111', '1', 'CUV', '2022-1-1', '2023-1-1', '10');
INSERT INTO `quanlyxe`.`dangkycungcap` (`MaDangKyCungCap`, `MaNhaCC`, `MaLoaiDV`, `MaMP`, `DongXe`, `NgayBatDauCungCap`, `NgayKetThucCungCap`, `SoLuongXeDangKy`) VALUES ('CCDV2', 'A2', '222', '2', 'sedan', '2022-1-2', '2023-2-3', '10');
INSERT INTO `quanlyxe`.`dangkycungcap` (`MaDangKyCungCap`, `MaNhaCC`, `MaLoaiDV`, `MaMP`, `DongXe`, `NgayBatDauCungCap`, `NgayKetThucCungCap`, `SoLuongXeDangKy`) VALUES ('CCDV3', 'A3', '333', '3', 'SUV', '2021-2-3', '2024-2-5', '15');

SELECT *
from nhacungcap as ncc join dangkycungcap as dkcc on ncc.manhacc = dkcc.MaNhaCC
	 join dongxe on dkcc.dongxe = dongxe.dongxe
	 join mucphi on dkcc.mamp = mucphi.mamp
where (hangxe = 'Toyota' and dongia = 15000) or (hangxe = 'kia' and dongia = 20000);

-- Câu 5: Liệt kê thông tin toàn bộ nhà cung cấp được sắp xếp tăng dần theo tên nhà cung
-- cấp và giảm dần theo mã số thuế 

SELECT * 
FROM nhacungcap 
ORDER BY TenNhaCC ASC , MaSoThue DESC
LIMIT 3;

-- Câu 6: Đếm số lần đăng ký cung cấp phương tiện tương ứng cho từng nhà cung cấp với
-- yêu cầu chỉ đếm cho những nhà cung cấp thực hiện đăng ký cung cấp có ngày bắt đầu
-- cung cấp là “20/11/2015”

SELECT TenNhaCC, COUNT ( MaDangKyCungCap )
FROM dangkycungcap 
WHERE NgaybatDauCungCap >= “20/11/2015”
GROUP BY nhacungcap;




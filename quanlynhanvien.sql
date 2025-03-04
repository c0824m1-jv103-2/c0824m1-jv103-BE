-- CREATE DATABASE QuanLyNhanVien;
USE QuanLyNhanVien;

CREATE TABLE PhongBan (
    MaPhongBan INT PRIMARY KEY AUTO_INCREMENT,
    TenPhongBan VARCHAR(100) NOT NULL
);

CREATE TABLE NhanVien (
    MaNV INT PRIMARY KEY AUTO_INCREMENT,
    HoTen VARCHAR(100) NOT NULL,
    NgaySinh DATE DEFAULT NULL,
    GioiTinh ENUM('Nam', 'Nữ', 'Khác') NOT NULL,
    ChucVu VARCHAR(50),
    Email VARCHAR(100) UNIQUE,
    CCCD VARCHAR(12) UNIQUE,
    MaPhongBan INT, -- Thêm khóa ngoại
    FOREIGN KEY (MaPhongBan) REFERENCES PhongBan(MaPhongBan) ON DELETE SET NULL
);

CREATE TABLE HopDong (
    MaHD INT PRIMARY KEY AUTO_INCREMENT,
    MaNV INT,
    NgayBatDau DATE NOT NULL,
    NgayKetThuc DATE DEFAULT NULL,
    Luong DECIMAL(12,2) NOT NULL,
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE CASCADE
);

CREATE TABLE DuAn (
    MaDuAn INT PRIMARY KEY AUTO_INCREMENT,
    TenDuAn VARCHAR(100) NOT NULL
);

CREATE TABLE PhanCong (
    MaNV INT,
    MaDuAn INT,
    PRIMARY KEY (MaNV, MaDuAn),
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE CASCADE,
    FOREIGN KEY (MaDuAn) REFERENCES DuAn(MaDuAn) ON DELETE CASCADE
);

CREATE TABLE KhenThuongPhat (
    Ma INT PRIMARY KEY AUTO_INCREMENT,
    MaNV INT,
    Loai ENUM('Khen thưởng', 'Phạt') NOT NULL,
    SoTien DECIMAL(12,2) NOT NULL DEFAULT 0,
    LyDo TEXT NOT NULL,
    Ngay DATE NOT NULL,
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV) ON DELETE CASCADE
);

-- Sử dụng cơ sở dữ liệu
USE QuanLyNhanVien;

-- Nhập dữ liệu vào bảng PhongBan
INSERT INTO PhongBan (TenPhongBan) VALUES 
('Hành Chính'), 
('Kế Toán'), 
('Nhân Sự'), 
('IT'), 
('Marketing');

-- Nhập dữ liệu vào bảng NhanVien 
INSERT INTO NhanVien (HoTen, NgaySinh, GioiTinh, ChucVu, Email, CCCD, MaPhongBan) VALUES 
('Nguyễn Văn A', '1990-05-15', 'Nam', 'Trưởng phòng', 'nguyenvana@example.com', '123456789012', 1),
('Trần Thị B', '1995-08-22', 'Nữ', 'Nhân viên', 'tranthib@example.com', '234567890123', 2),
('Lê Hoàng C', '1988-12-10', 'Nam', 'Nhân viên', 'lehoangc@example.com', '345678901234', 3),
('Phạm Minh D', '1992-03-05', 'Nam', 'Quản lý', 'phamminhd@example.com', '456789012345', 4),
('Hoàng Lan E', '2000-07-18', 'Nữ', 'Thực tập sinh', 'hoanglane@example.com', '567890123456', 5),
('Đỗ Hải F', '1993-09-25', 'Nam', 'Nhân viên', 'dohaif@example.com', '678901234567', 1),
('Vũ Hữu G', '1991-11-30', 'Nam', 'Trưởng phòng', 'vuhuug@example.com', '789012345678', 2),
('Ngô Thị H', '1998-04-20', 'Nữ', 'Nhân viên', 'ngothih@example.com', '890123456789', 3),
('Bùi Văn I', '1985-06-12', 'Nam', 'Giám đốc', 'buivani@example.com', '901234567890', NULL),
('Cao Phương J', '1994-10-05', 'Nữ', 'Nhân viên', 'caophuongj@example.com', '012345678901', 5),
('Nguyễn Hoàng K', '1996-01-15', 'Nam', 'Nhân viên', 'nguyenhoangk@example.com', '112345678902', 1),
('Trần Mai L', '1997-03-22', 'Nữ', 'Nhân viên', 'tranmail@example.com', '212345678903', 2),
('Lê Bảo M', '1999-07-30', 'Nam', 'Trưởng phòng', 'lebaom@example.com', '312345678904', 3),
('Phạm Thanh N', '1989-12-05', 'Nam', 'Nhân viên', 'phamthanhn@example.com', '412345678905', 4),
('Hoàng Duy O', '1993-06-25', 'Nam', 'Nhân viên', 'hoangduyo@example.com', '512345678906', 5),
('Đỗ Minh P', '1995-09-15', 'Nam', 'Nhân viên', 'dominhp@example.com', '612345678907', 1),
('Vũ Thị Q', '1998-11-20', 'Nữ', 'Nhân viên', 'vuthiq@example.com', '712345678908', 2),
('Ngô Đình R', '2000-02-14', 'Nam', 'Nhân viên', 'ngodinhR@example.com', '812345678909', 3),
('Bùi Hạnh S', '1987-08-01', 'Nữ', 'Quản lý', 'buihanhs@example.com', '912345678910', 4),
('Cao Văn T', '1991-04-10', 'Nam', 'Nhân viên', 'caovant@example.com', '012345678911', 5);

-- Nhập dữ liệu vào bảng HopDong
INSERT INTO HopDong (MaNV, NgayBatDau, NgayKetThuc, Luong) VALUES 
(1, '2023-01-01', '2025-01-01', 15000000.00),
(2, '2022-06-15', '2024-06-15', 12000000.00),
(3, '2021-09-01', NULL, 18000000.00),
(4, '2023-05-10', '2026-05-10', 17000000.00),
(5, '2022-12-20', NULL, 8000000.00),
(6, '2023-02-10', '2025-02-10', 10000000.00),
(7, '2021-11-25', NULL, 22000000.00),
(8, '2022-07-14', '2025-07-14', 13000000.00),
(9, '2023-04-18', NULL, 16000000.00),
(10, '2022-08-30', NULL, 9000000.00),
(11, '2021-12-11', '2024-12-11', 14000000.00),
(12, '2023-06-21', NULL, 15500000.00),
(13, '2022-05-09', NULL, 17500000.00),
(14, '2021-10-15', '2023-10-15', 12500000.00),
(15, '2023-09-01', NULL, 13500000.00),
(16, '2022-04-17', NULL, 14500000.00),
(17, '2023-03-12', '2025-03-12', 19000000.00),
(18, '2021-07-19', NULL, 19500000.00),
(19, '2022-01-23', NULL, 11000000.00),
(20, '2023-10-02', NULL, 8500000.00);

-- Nhập dữ liệu vào bảng KhenThuongPhat
INSERT INTO KhenThuongPhat (MaNV, Loai, SoTien, LyDo, Ngay) VALUES 
(1, 'Khen thưởng', 500000, 'Hoàn thành xuất sắc công việc', '2023-10-15'),
(2, 'Phạt', 200000, 'Đi làm muộn 3 lần', '2023-09-10'),
(3, 'Khen thưởng', 1000000, 'Đạt doanh số cao', '2023-08-05'),
(4, 'Phạt', 500000, 'Không hoàn thành nhiệm vụ', '2023-07-20'),
(5, 'Khen thưởng', 750000, 'Ý tưởng sáng tạo', '2023-06-25'),
(6, 'Khen thưởng', 300000, 'Hỗ trợ đồng nghiệp', '2023-05-18'),
(7, 'Phạt', 100000, 'Làm việc riêng trong giờ', '2023-04-10'),
(8, 'Khen thưởng', 600000, 'Hoàn thành dự án trước hạn', '2023-03-12'),
(9, 'Phạt', 250000, 'Không tuân thủ nội quy', '2023-02-14'),
(10, 'Khen thưởng', 1200000, 'Đóng góp ý tưởng sáng tạo', '2023-01-30'),
(11, 'Khen thưởng', 800000, 'Nỗ lực làm việc ngoài giờ', '2023-11-22'),
(12, 'Phạt', 150000, 'Nghỉ không phép', '2023-10-05'),
(13, 'Khen thưởng', 900000, 'Giải quyết sự cố nhanh chóng', '2023-09-18'),
(14, 'Phạt', 300000, 'Không báo cáo tiến độ công việc', '2023-08-30'),
(15, 'Khen thưởng', 1100000, 'Đóng góp ý kiến cải tiến quy trình', '2023-07-14'),
(16, 'Khen thưởng', 450000, 'Tích cực tham gia hoạt động công ty', '2023-06-20'),
(17, 'Phạt', 200000, 'Không đeo thẻ nhân viên', '2023-05-25'),
(18, 'Khen thưởng', 1300000, 'Được khách hàng đánh giá cao', '2023-04-08'),
(19, 'Phạt', 500000, 'Gây ảnh hưởng đến đồng nghiệp', '2023-03-05'),
(20, 'Khen thưởng', 700000, 'Đạt thành tích xuất sắc trong quý', '2023-02-28');

-- Nhập dữ liệu vào bảng DuAn
INSERT INTO DuAn (TenDuAn) VALUES 
('Hệ thống CRM khách hàng'),
('Ứng dụng di động bán hàng'),
('Website thương mại điện tử'),
('Nền tảng học trực tuyến'),
('Dự án AI nhận diện khuôn mặt'),
('Hệ thống quản lý kho hàng'),
('Ứng dụng đặt lịch hẹn bác sĩ'),
('Dự án Blockchain thanh toán'),
('Cổng thông tin việc làm'),
('Hệ thống chấm công tự động'),
('Phần mềm quản lý tài chính cá nhân'),
('Ứng dụng theo dõi sức khỏe'),
('Hệ thống quản lý nhân sự'),
('Hệ thống bán vé trực tuyến'),
('Dự án AI phân tích dữ liệu lớn'),
('Ứng dụng giao hàng thông minh'),
('Nền tảng tuyển dụng trực tuyến'),
('Phần mềm quản lý khách sạn'),
('Ứng dụng học ngôn ngữ AI'),
('Dự án an ninh mạng doanh nghiệp');

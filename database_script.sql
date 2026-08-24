CREATE DATABASE lab10_secured CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE lab10_secured;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,
    active BOOLEAN DEFAULT TRUE
);

-- Dữ liệu mẫu (Bài 6 phần B), có thể để AppListener tự sinh thay vì chèn tay
INSERT INTO users (email, password, full_name, role, active) VALUES
('admin@eaut.edu.vn', 'admin123', 'Quản trị viên', 'ADMIN', TRUE),
('staff@eaut.edu.vn', 'staff123', 'Nhân viên', 'STAFF', TRUE),
('user@eaut.edu.vn', 'user123', 'Người dùng', 'USER', TRUE);
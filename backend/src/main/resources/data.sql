-- Tạo dữ liệu mẫu cho các kỹ năng
INSERT INTO skills (subject, value, full_mark) VALUES 
('Sức khỏe', 7, 10),
('Tài chính', 5, 10),
('Sự nghiệp', 6, 10),
('Mối quan hệ', 8, 10),
('Phát triển cá nhân', 6, 10),
('Tinh thần', 7, 10);

-- Tạo dữ liệu mẫu cho các nhiệm vụ
INSERT INTO tasks (text, completed) VALUES 
('Học Spring Boot', false),
('Luyện tập thể dục', false),
('Đọc sách 30 phút', false),
('Chuẩn bị báo cáo', true),
('Gọi điện cho gia đình', true);

-- Tạo dữ liệu mẫu cho nhật ký
INSERT INTO journal_entries (title, content, date) VALUES 
('Ngày đầu tiên học Spring Boot', 'Hôm nay tôi đã bắt đầu học Spring Boot. Tôi đã tạo được một dự án đơn giản và hiểu được cách hoạt động cơ bản.', NOW()),
('Kế hoạch phát triển bản thân', 'Tôi đã lập kế hoạch phát triển bản thân trong 6 tháng tới, tập trung vào việc học các công nghệ mới và cải thiện sức khỏe.', NOW() - INTERVAL 1 DAY),
('Suy ngẫm về tuần qua', 'Tuần qua đã có nhiều thách thức nhưng cũng đạt được nhiều thành tựu. Tôi cần cải thiện khả năng quản lý thời gian.', NOW() - INTERVAL 3 DAY); 
# Backend - Ứng dụng Quản lý Cá nhân

Backend của ứng dụng Quản lý Cá nhân được xây dựng bằng:

- Java Spring Boot
- Spring Data JPA
- MySQL

## Cài đặt và chạy

1. Cấu hình kết nối MySQL trong `src/main/resources/application.properties`
2. Chạy ứng dụng với Maven:

```bash
mvn spring-boot:run
```

3. API sẽ khả dụng tại: http://localhost:8080

## Cấu trúc thư mục

- `src/main/java/com/personal/manager/model`: Các entity/model
- `src/main/java/com/personal/manager/repository`: Các repository để truy cập CSDL
- `src/main/java/com/personal/manager/service`: Các service xử lý logic nghiệp vụ
- `src/main/java/com/personal/manager/controller`: Các REST controller phục vụ API
- `src/main/resources`: Cấu hình và tài nguyên

## API Endpoints

### Journal API

- `GET /api/journal/entries`: Lấy tất cả bài viết nhật ký
- `GET /api/journal/entries/{id}`: Lấy bài viết nhật ký theo ID
- `POST /api/journal/entries`: Tạo bài viết nhật ký mới
- `PUT /api/journal/entries/{id}`: Cập nhật bài viết nhật ký
- `DELETE /api/journal/entries/{id}`: Xóa bài viết nhật ký

### Task API

- `GET /api/tasks`: Lấy tất cả nhiệm vụ
- `GET /api/tasks/{id}`: Lấy nhiệm vụ theo ID
- `POST /api/tasks`: Tạo nhiệm vụ mới
- `PUT /api/tasks/{id}`: Cập nhật nhiệm vụ
- `PATCH /api/tasks/{id}/toggle`: Đánh dấu nhiệm vụ hoàn thành/chưa hoàn thành
- `DELETE /api/tasks/{id}`: Xóa nhiệm vụ

### Skill API

- `GET /api/skills`: Lấy tất cả kỹ năng
- `GET /api/skills/{id}`: Lấy kỹ năng theo ID
- `GET /api/skills/subject/{subject}`: Lấy kỹ năng theo tên
- `POST /api/skills`: Tạo kỹ năng mới
- `PUT /api/skills/{id}`: Cập nhật kỹ năng
- `PUT /api/skills`: Cập nhật tất cả kỹ năng
- `PATCH /api/skills/subject/{subject}`: Cập nhật giá trị kỹ năng theo tên
- `DELETE /api/skills/{id}`: Xóa kỹ năng

# Ứng dụng Quản lý Cá nhân

Ứng dụng Quản lý Cá nhân là một nền tảng giúp người dùng theo dõi và quản lý các mặt khác nhau của cuộc sống:

- Viết nhật ký hàng ngày
- Quản lý danh sách nhiệm vụ
- Đánh giá các khía cạnh cá nhân qua biểu đồ radar

## Cấu trúc dự án

- `frontend`: React TypeScript, xây dựng bằng Vite
- `backend`: Java Spring Boot với MySQL

## Yêu cầu hệ thống

- Node.js và pnpm
- Java 11+
- Maven
- MySQL

## Cài đặt và chạy

### Backend

1. Đảm bảo MySQL đang chạy
2. Cấu hình kết nối MySQL trong `backend/src/main/resources/application.properties`
3. Chạy ứng dụng Spring Boot:
   ```
   cd backend
   mvn spring-boot:run
   ```

### Frontend

1. Cài đặt các dependencies:

   ```
   cd frontend
   pnpm install
   ```

2. Chạy ứng dụng:

   ```
   pnpm run dev
   ```

3. Mở ứng dụng tại `http://localhost:5173`

## Tính năng

### Nhật ký

- Viết, chỉnh sửa và xóa các bài viết nhật ký
- Tự động lưu thời gian tạo

### Nhiệm vụ

- Thêm, đánh dấu hoàn thành và xóa các nhiệm vụ
- Theo dõi trạng thái nhiệm vụ

### Biểu đồ radar

- Đánh giá 6 khía cạnh cuộc sống: Sức khỏe, Tài chính, Sự nghiệp, Mối quan hệ, Phát triển cá nhân, Tinh thần
- Điều chỉnh các giá trị và lưu lại thay đổi

# Backend - Ứng dụng Quản lý Cá nhân

## Vấn đề đang gặp phải

Hiện tại, dự án backend đang gặp lỗi vì thiếu các thư viện và cấu hình Maven đúng. Dưới đây là các bước để khắc phục:

## Yêu cầu hệ thống

- JDK 11 hoặc cao hơn
- Maven (tải từ: https://maven.apache.org/download.cgi)
- MySQL Server

## Cài đặt

1. **Cài đặt JDK**: Đảm bảo Java đã được cài đặt và biến môi trường JAVA_HOME đã được thiết lập

2. **Cài đặt Maven**:

   - Tải Maven từ https://maven.apache.org/download.cgi
   - Giải nén vào thư mục mong muốn
   - Thêm thư mục bin của Maven vào PATH
   - Kiểm tra cài đặt: `mvn -v`

3. **Cài đặt MySQL**:

   - Tải MySQL từ https://dev.mysql.com/downloads/installer/
   - Cài đặt và tạo một cơ sở dữ liệu mới tên "personal_manager"

4. **Cấu hình project**:
   - Chỉnh sửa file `src/main/resources/application.properties` để khớp với thông tin kết nối MySQL của bạn

## Chạy ứng dụng

Sau khi cài đặt xong, chạy dự án bằng:

```
mvn spring-boot:run
```

## API Endpoints

- `GET /api/journal/entries`: Lấy tất cả bài viết nhật ký
- `GET /api/tasks`: Lấy tất cả nhiệm vụ
- `GET /api/skills`: Lấy tất cả kỹ năng

## Sửa lỗi hiện tại

Nếu gặp lỗi liên quan đến thư viện javax.persistence, hãy thêm các dependency sau vào file pom.xml:

```xml
<dependency>
    <groupId>javax.persistence</groupId>
    <artifactId>javax.persistence-api</artifactId>
    <version>2.2</version>
</dependency>
```

Nếu vẫn gặp lỗi, hãy đảm bảo Maven được cài đặt đúng và thực hiện:

```
mvn clean
mvn install
```

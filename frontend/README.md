# Frontend - Ứng dụng Quản lý Cá nhân

Frontend của ứng dụng Quản lý Cá nhân được xây dựng bằng:

- React
- TypeScript
- Material UI (MUI)
- Recharts (cho biểu đồ radar)
- Axios (gọi API)

## Cài đặt và chạy

1. Cài đặt các dependencies:

```bash
pnpm install
```

2. Chạy ứng dụng ở chế độ development:

```bash
pnpm run dev
```

3. Truy cập ứng dụng tại: http://localhost:5173

## Cấu trúc thư mục

- `src/components/journal`: Components quản lý nhật ký
- `src/components/tasks`: Components quản lý nhiệm vụ
- `src/components/radar`: Components biểu đồ radar đánh giá các kỹ năng
- `src/services`: Service API để kết nối với backend
- `src/App.tsx`: Component chính của ứng dụng

## Build cho production

```bash
pnpm run build
```

File build sẽ được tạo trong thư mục `dist`.

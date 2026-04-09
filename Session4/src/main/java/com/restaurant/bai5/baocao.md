## Bẫy kiểu dữ liệu

Nếu người dùng nhâp sai kiểu chữ liệu (nhập chữ cái thay vì số) sẽ bắt lỗi này bằng try catch để tránh chương trình bị
crash.

## Tính Idempotent

- DELETE là idempotent vì gọi nhiều lần vẫn cho kết quả giống nhau (đơn hàng bị xóa hoặc không tồn tại).
- POST mỗi lần load loại sẽ tạo ra một request mới nên sẽ dẫn đến tạo ra dữ liệu rác.
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Khen Thưởng / Phạt</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* Reset CSS */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        /* Body styling */
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background: linear-gradient(to right, #1a237e, #3d5afe);
            padding: 20px;
        }

        /* Container styling */
        .container {
            max-width: 600px;
            width: 100%;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        /* Heading styling */
        h2 {
            text-align: center;
            margin-bottom: 20px;
            padding-bottom: 10px;
            font-size: 22px;
            border-bottom: 2px solid #eace0e;
        }

        /* Form elements */
        .form-label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-control, .form-select, textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
            background: white;
        }

        /* Button styling */
        .btn-primary {
            background: #ffeb3b;
            color: black;
            border: none;
            padding: 12px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            border-radius: 5px;
            transition: background 0.3s;
        }

        .btn-primary:hover {
            background: #fdd835;
        }

        .btn-secondary {
            background: #dc3545;
            color: white;
            border: none;
            padding: 12px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            border-radius: 5px;
            transition: background 0.3s;
        }

        .btn-secondary:hover {
            background: #c82333;
        }

        /* Button group */
        .d-flex {
            display: flex;
            justify-content: space-between;
            gap: 15px;
            margin-top: 20px;
        }
        .btn-save {
            background: #007bff; /* Màu xanh nước biển */
            color: white;
            border: none;
            padding: 12px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            border-radius: 5px;
            transition: background 0.3s;
        }

        .btn-save:hover {
            background: #0056b3; /* Màu xanh nước biển đậm hơn khi hover */
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <h2 class="text-center">Nhập Thông Tin Khen Thưởng / Phạt</h2>
    <form method="post">
        <div class="mb-3">
            <label class="form-label">Mã Nhân Viên:</label>
            <select class="form-select" name="Ma" required>
                <option value="" selected>-- Chọn nhân viên --</option>
                <c:forEach var="item" items="${nhanViens}" varStatus="status">
                    <option value="${item.maNV}">
                            ${item.maNV}. ${item.hoTen}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="mb-3">
            <label class="form-label">Loại:</label>
            <select class="form-select" name="Loai" required>
                <option value="Khen thưởng">Khen thưởng</option>
                <option value="Phạt">Phạt</option>
            </select>
        </div>

        <div class="mb-3">
            <label class="form-label">Số Tiền:</label>
            <input type="number" step="0.01" class="form-control" name="SoTien" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Lý Do:</label>
            <textarea class="form-control" name="LyDo" rows="3" required></textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Ngày:</label>
            <input type="date" class="form-control" name="Ngay" required>
            <div class="invalid-feedback">Vui lòng chọn ngày không lớn hơn hôm nay.</div>
        </div>

        <div class="d-flex justify-content-between">
            <button type="button" class="btn btn-secondary" onclick="history.back()">Quay lại</button>
            <button type="submit" class="btn btn-save">Lưu</button>
        </div>
    </form>
</div>
<script>
    document.querySelector("form").addEventListener("submit", function(event) {
        let soTien = document.querySelector('input[name="SoTien"]').value;
        if (parseFloat(soTien) <= 0) {
            alert("Số tiền phải lớn hơn 0!");
            event.preventDefault();
        }
    });
</script>
<script>
    document.querySelector("form").addEventListener("submit", function(event) {
        let ngayInput = document.querySelector('input[name="Ngay"]').value;
        let ngayNhap = new Date(ngayInput);
        let homNay = new Date();
        homNay.setHours(0, 0, 0, 0);

        if (!ngayInput || ngayNhap > homNay) {
            alert("Ngày không được lớn hơn hôm nay!");
            event.preventDefault();
        }
    });
</script>
</body>
</html>
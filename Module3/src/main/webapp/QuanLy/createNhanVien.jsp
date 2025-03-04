<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới nhân viên</title>
    <link rel="stylesheet" href="/css/create.css">
    <script>
        function validateForm(event) {
            event.preventDefault();

            let hoTen = document.getElementById("HoTen").value.trim();
            let ngaySinh = document.getElementById("NgaySinh").value;
            let gioiTinh = document.querySelector("select[name='GioiTinh']").value;
            let chucVu = document.querySelector("input[name='ChucVu']").value.trim();
            let email = document.querySelector("input[name='Email']").value.trim();
            let cccd = document.querySelector("input[name='CCCD']").value.trim();
            let tenPhongBan = document.querySelector("select[name='TenPhongBan']").value;

            let emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
            let cccdRegex = /^\d{9}$|^\d{12}$/;

            let errors = [];

            if (!hoTen && !ngaySinh && !gioiTinh && !chucVu && !email && !cccd && !tenPhongBan) {
                alert("Vui lòng nhập đầy đủ thông tin!");
                return;
            }

            if (!hoTen) errors.push("Họ và tên không được để trống.");
            if (!ngaySinh) errors.push("Ngày sinh không được để trống.");
            if (!gioiTinh) errors.push("Vui lòng chọn giới tính.");
            if (!chucVu) errors.push("Chức vụ không được để trống.");
            if (!email) {
                errors.push("Email không được để trống.");
            } else if (!emailRegex.test(email)) {
                errors.push("Địa chỉ email không hợp lệ.");
            }
            if (!cccd) {
                errors.push("Số CMND/CCCD không được để trống.");
            } else if (!cccdRegex.test(cccd)) {
                errors.push("Số CMND/CCCD phải có 9 hoặc 12 chữ số.");
            }
            if (!tenPhongBan) errors.push("Vui lòng chọn phòng ban.");

            if (ngaySinh) {
                let today = new Date();
                let birthDate = new Date(ngaySinh);
                let age = today.getFullYear() - birthDate.getFullYear();
                let monthDiff = today.getMonth() - birthDate.getMonth();
                if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
                    age--;
                }
                if (age < 18) {
                    errors.push("Nhân viên phải đủ 18 tuổi trở lên.");
                }
            }

            if (errors.length > 0) {
                alert(errors.join("\n"));
                return;
            }

            event.target.submit();
        }
    </script>
</head>
<body>
<div class="container">
    <h2>Tạo mới nhân viên</h2>
    <form action="/phongban?action=createNhanVien2" method="post" onsubmit="validateForm(event)">
        <div class="form-group">
            <label for="HoTen">Họ và tên</label>
            <input type="text" class="form-control" id="HoTen" name="HoTen" placeholder="Nhập họ và tên ">
        </div>
        <div class="form-group">
            <label for="NgaySinh">Ngày sinh</label>
            <input type="date" class="form-control" id="NgaySinh" name="NgaySinh">
        </div>
        <div class="form-group">
            <label>Giới tính</label>
            <select name="GioiTinh">
                <option value="" disabled selected>-- Chọn giới tính --</option>
                <option value="Nam">Nam</option>
                <option value="Nữ">Nữ</option>
                <option value="Khác">Khác</option>
            </select>
        </div>
        <div class="form-group">
            <label>Chức vụ</label>
            <input type="text" name="ChucVu">
        </div>
        <div class="form-group">
            <label>Địa chỉ email</label>
            <input type="email" name="Email">
        </div>
        <div class="form-group">
            <label>Số CMND/CCCD</label>
            <input type="text" name="CCCD">
        </div>
        <div class="form-group">
            <label>Tên phòng ban</label>
            <select name="TenPhongBan">
                <option value="" disabled selected>-- Chọn phòng ban --</option>
                <option value="Hành Chính">Hành Chính</option>
                <option value="Kế Toán">Kế Toán</option>
                <option value="Nhân Sự">Nhân Sự</option>
                <option value="IT">IT</option>
                <option value="Marketing">Marketing</option>
            </select>
        </div>
        <div class="buttons">
            <button type="submit" class="save">Lưu lại</button>
            <button type="button" class="cancel" onclick="window.history.back();">Hủy bỏ</button>
        </div>
    </form>
</div>
</body>
</html>

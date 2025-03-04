<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="/css/KhenThuong.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<div class="container-custom">
    <h2 class="mb-3 text-center">Danh Sách Khen Thưởng & Phạt</h2>

    <c:if test="${not empty sessionScope.message}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
                ${sessionScope.message}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close" onclick="removeMessage()">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <c:remove var="message" scope="session"/>
    </c:if>

    <div class="button-group-custom">
        <button onclick="window.location.href='/phongban' +
         '';">⬅️</button>
        <div class="combo-wrapper-custom" >
            <select id="filterSelect" class="form-select me-2">
                <option value="">Tất cả</option>
                <option value="Khen thưởng">Khen thưởng</option>
                <option value="Phạt">Phạt</option>
            </select>
            <button class="btn btn-primary" onclick="applyFilter()">Chọn</button>
        </div>
        <button onclick="window.location.href='/phongban?action=createKhenThuong'">➕</button>
    </div>

    <table class="custom-table custom-table-bordered">
        <thead class="custom-table-header">
        <tr>
            <th>Mã NV</th>
            <th>Loại</th>
            <th>Số Tiền</th>
            <th>Lý Do</th>
            <th>Ngày</th>
            <th>Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${khenThuongs}">
            <tr class="${item.loai eq 'Khen thưởng' ? 'custom-success' : (item.loai eq 'Phạt' ? 'custom-danger' : '')}">
                <td>${item.ma}</td>
                <td>${item.loai}</td>
                <td>${item.soTienFormatted}</td>
                <td>${item.lyDo}</td>
                <td>${item.ngayFormatted}</td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="##delete${item.ma}">
                        Xóa
                    </button>
                </td>
                <!-- Modal -->
                <div class="modal fade" id="#delete${item.ma}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Xóa ${item.loai}</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Bạn có muốn xóa nhân viên có mã là ${item.ma} này không
                                <br>
                                <i style="color: red">    Hành động này không thể hoàn tác</i>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                                <button type="button" class="btn btn-primary" onclick="window.location.href='/phongban?action=deleteKhenThuong&id=${item.ma}'">Xác nhận</button>
                            </div>
                        </div>
                    </div>
                </div>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script>
    function applyFilter() {
        let selectedValue = document.getElementById("filterSelect").value;
        window.location.href = "/phongban?action=loaiKhenThuong&id=" + encodeURIComponent(selectedValue);
    }
</script>
<script>
    function applyFilter() {
        let selectedValue = document.getElementById("filterSelect").value;
        window.location.href = "/phongban?action=loaiKhenThuong&id=" + encodeURIComponent(selectedValue);
    }
</script>
<script>
    function removeMessage() {
        fetch('/removeMessage', { method: 'POST' });
    }

    setTimeout(() => {
        document.querySelector('.alert')?.remove();
    }, 3000);
</script>

</body>
</html>
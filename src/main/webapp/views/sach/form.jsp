<%@ page contentType="text/html;charset=UTF-8" %>
<h2>Thông tin sách</h2>
<form method="post" action="${pageContext.request.contextPath}/sach">
<input type="hidden" name="id" value="${sach.id}">
Mã sách <input name="maSach" value="${sach.maSach}" required><br>
Tên sách <input name="tenSach" value="${sach.tenSach}" required><br>
Tác giả <input name="tacGia" value="${sach.tacGia}"><br>
Thể loại <input name="theLoai" value="${sach.theLoai}"><br>
Số lượng <input type="number" name="soLuong" value="${sach.soLuong}" required><br>
<button>Lưu</button>
</form><a href="${pageContext.request.contextPath}/sach">Quay lại</a>

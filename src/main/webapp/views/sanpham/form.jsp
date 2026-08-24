<%@ page contentType="text/html;charset=UTF-8" %>
<h2>Thông tin sản phẩm</h2>
<form method="post" action="${pageContext.request.contextPath}/san-pham">
<input type="hidden" name="id" value="${sanPham.id}">
Mã sản phẩm <input name="maSanPham" value="${sanPham.maSanPham}" required><br>
Tên sản phẩm <input name="tenSanPham" value="${sanPham.tenSanPham}" required><br>
Giá <input type="number" step="0.01" name="gia" value="${sanPham.gia}" required><br>
Số lượng tồn <input type="number" name="soLuongTon" value="${sanPham.soLuongTon}" required><br>
<button>Lưu</button>
</form><a href="${pageContext.request.contextPath}/san-pham">Quay lại</a>

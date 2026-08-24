<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html><head><title>Quản lý người dùng</title></head><body>
<h1>Quản lý người dùng</h1>
<p><a href="${pageContext.request.contextPath}/admin/index.jsp">Quản trị</a> | <a href="${pageContext.request.contextPath}/dashboard.jsp">Dashboard</a></p>
<table border="1" cellpadding="6">
<tr><th>ID</th><th>Email</th><th>Họ tên</th><th>Vai trò</th><th>Hoạt động</th><th>Lưu</th></tr>
<c:forEach var="user" items="${users}">
<tr><form method="post" action="${pageContext.request.contextPath}/admin/users">
<td>${user.id}<input type="hidden" name="id" value="${user.id}"></td>
<td>${user.email}</td>
<td><input name="fullName" value="${user.fullName}" required></td>
<td><select name="role"><option value="ADMIN" ${user.role == 'ADMIN' ? 'selected' : ''}>ADMIN</option><option value="STAFF" ${user.role == 'STAFF' ? 'selected' : ''}>STAFF</option><option value="USER" ${user.role == 'USER' ? 'selected' : ''}>USER</option></select></td>
<td><input type="checkbox" name="active" value="true" ${user.active ? 'checked' : ''}></td>
<td><button type="submit">Lưu</button></td></form></tr>
</c:forEach></table>
</body></html>

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><title>Đăng nhập hệ thống</title></head>
<body>
<h2>Đăng nhập hệ thống</h2>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
<form method="post" action="${pageContext.request.contextPath}/auth">
    <p>Email: <input type="email" name="email" required></p>
    <p>Mật khẩu: <input type="password" name="password" required></p>
    <button type="submit">Đăng nhập</button>
</form>
</body>
</html>

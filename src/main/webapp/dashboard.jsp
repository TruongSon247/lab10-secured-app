<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head><title>Dashboard</title></head>
<body>
<c:if test="${empty sessionScope.currentUser}">
    <c:redirect url="/login.jsp"/>
</c:if>
<h2>Xin chào, ${sessionScope.currentUser.fullName} (${sessionScope.currentUser.role})</h2>

<ul>
    <c:if test="${sessionScope.currentUser.role == 'ADMIN'}">
        <li><a href="${pageContext.request.contextPath}/admin/index.jsp">Quản trị hệ thống</a></li>
    </c:if>
    <c:if test="${sessionScope.currentUser.role == 'ADMIN' || sessionScope.currentUser.role == 'STAFF'}">
        <li><a href="${pageContext.request.contextPath}/staff/index.jsp">Nghiệp vụ (Sinh viên/Sách/Sản phẩm)</a></li>
    </c:if>
    <li><a href="${pageContext.request.contextPath}/user/profile.jsp">Hồ sơ cá nhân</a></li>
    <li><a href="${pageContext.request.contextPath}/auth?action=logout">Đăng xuất</a></li>
</ul>
</body>
</html>

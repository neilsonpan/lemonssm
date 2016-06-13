<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <h3 style="color:red">${param.error}</h3>
    <form:form action="/user/login" method="post">
        <label>用户名:</label>
        <input type="text" name="userName" value="${param.userName}">
        <label>密  码:</label>
        <input type="text" name="password" value="${param.password}">

        <button type="submit">提交</button>
    </form:form>
</body>
</html>

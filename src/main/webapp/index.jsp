<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>登陆</title>
    <%
        HttpSession s = request.getSession();
    %>
    <script>
        var id = <%=s.getAttribute("id")%>;
        if (id)
        {
            location.href = "/customer/index";
        }
    </script>

</head>

<body>

    <div class="row" style="margin-top: 150px;">
        <div class="col-lg-4"></div>
        <div class="col-lg-5">
            <c:if test="${!empty param.error}">
                <div class="alert alert-danger" role="alert">${param.error}</div>
            </c:if>

            <form:form action="/user/login" method="post">
                <div class="form-group">
                    <label>用户名: </label>
                    <input  class="form-group" type="text" name="userName" value="${param.userName}">
                </div>

                <div class="form-group">
                    <label>密&nbsp;&nbsp;码: </label>
                    <input class="form-group" type="text" name="password" value="${param.password}">
                </div>

                <button type="submit" class="btn btn-default">提交</button>
            </form:form>
        </div>
        <div class="col-lg-3"></div>
    </div>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="js/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>

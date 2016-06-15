<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>客户管理</title>
</head>
<body>
    <div class="row" style="margin-top: 30px">

        <div class="col-lg-6">
            <form:form action="/customer/index" method="post" class="form-inline">
                <div class="form-group">
                    <label>手机号</label>
                    <input class="form-group" type="text" name="mobile" value="${mobile}" />
                </div>

                <button type="submit" class="btn btn-primary btn-group-sm">查询</button>
            </form:form>
        </div>

        <div class="col-lg-2">
            <a href="/customer/add" class="btn btn-primary btn-sm">添加</a>
        </div>
    </div>

    <table class="table table-hover">
        <thead>
            <tr>
                <th>客户名字</th>
                <th>手机账号</th>
                <th>银行卡</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${!empty customers}">
                <c:forEach items="${customers}" var="customer">
                    <tr>
                        <td>${customer.customerName}</td>
                        <td>${customer.mobile}</td>
                        <td>${customer.bankCard}</td>
                        <td><a href="/customer/update?id=${customer.id}" type="button" class="btn btn-sm btn-warning">修改</a></td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="/js/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="/js/bootstrap.min.js"></script>
</body>
</html>

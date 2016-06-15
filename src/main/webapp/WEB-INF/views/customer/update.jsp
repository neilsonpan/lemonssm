<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/13
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>客户添加</title>
</head>
<body>
<div class="row" style="margin-top: 30px;">
    <div class="col-lg-2"></div>
    <div class="col-lg-6">
        <c:if test="${!empty error}">
            <div class="alert alert-danger" role="alert">${error}</div>
        </c:if>

        <form:form action="/customer/update" method="post">
            <div class="form-group">
                <label for="customerName">用户名:</label>
                <input type="text" class="form-group" id="customerName" name="customerName" value="${customer.customerName}">
            </div>

            <div class="form-group">
                <label for="mobile">手机号:</label>
                <input type="text" class="form-group" id="mobile" name="mobile" value="${customer.mobile}">
            </div>

            <div class="form-group">
                <label for="password">密  码:</label>
                <input type="text" id="password" name="password" value="${customer.password}">
            </div>

            <div class="form-group">
                <label for="effective">有效性:</label>
                <select id="effective" name="effective">
                    <option value="0" ${customer.effective == 0 ? "selected=selected" : ""}>未验证</option>
                    <option value="1" ${customer.effective == 1 ? "selected=selected" : ""}>验证无效</option>
                    <option value="2" ${customer.effective == 2 ? "selected=selected" : ""}>验证有效</option>
                </select>
            </div>

            <input type="hidden" name="id" value="${customer.id}">
            <button type="submit" class="btn btn-default">提交</button>
        </form:form>
    </div>
</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/13
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>添加</title>
</head>
<body>
    <h3>${error}</h3>
    <form:form action="/customer/add" method="post">
        <label>用户名:</label>
        <input type="text" name="customerName" value="${customer.customerName}">

        <label>手机号:</label>
        <input type="text" name="mobile" value="${customer.mobile}">

        <label>密  码:</label>
        <input type="text" name="password" value="${customer.password}">

        <label>有效性:</label>
        <select name="effective">
            <option value="0" ${customer.effective == 0 ? "selected=selected" : ""}>未验证</option>
            <option value="1" ${customer.effective == 1 ? "selected=selected" : ""}>验证无效</option>
            <option value="2" ${customer.effective == 2 ? "selected=selected" : ""}>验证有效</option>
        </select>

        <button type="submit">提交</button>
    </form:form>
</body>
</html>

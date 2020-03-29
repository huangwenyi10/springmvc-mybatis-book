<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div align="center">用户管理系统</div><br>
<div style="margin-left:63%"><button id="in" onclick="into()">办理入职</button></div>
<table border="1" align="center">
    <tr>
        <td>姓名</td>
        <td>工号</td>
        <td>职位</td>
        <td>状态</td>
        <td>操作</td>
    </tr>
<c:forEach items="${users}" var="user">
    <tr>
        <td width="50">${user.name}</td>
        <td width="50">${user.no}</td>
        <td width="150">${user.position}</td>
        <td  width="100"> ${user.status}</td>
        <td  width="200"><button id="out" onclick="out(${user.id})">办理离职</button>
            <button id="update" onclick="info(${user.id})">信息更新</button></td>
    </tr>

</c:forEach>

</table>
</body>
<script>

    function into() {
        var url = "http://localhost:8080/sysUser/in"
        window.open(url,'_self');
    }

    function out(id) {
        var userId = id
        var url = "http://localhost:8080/sysUser/out?id=" + userId;
        window.open(url,'_self');
    }

    function info(id) {
        var userId = id
        var url = "http://localhost:8080/sysUser/updateInfo?id=" + userId;
        window.open(url,'_self');
    }
</script>

</html>


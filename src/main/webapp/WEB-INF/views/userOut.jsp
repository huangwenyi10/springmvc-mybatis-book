<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div align="center">员工离职办理</div><br>
<table border="1" align="center">
    <tr>
        <td>姓名</td><td><input id="name" value="${user.name}"/></td>
    </tr>
    <tr>
        <td>工号</td><td><input id="no" value="${user.no}"/></td>
    </tr>
    <tr>
        <td>职位</td><td><input id="position" value="${user.position}"/></td>
    </tr>
    <tr>
        <td>状态</td><td><input id="status" value="${user.status}"/></td>
    </tr>
    <tr>
        <td>离职原因</td><td><input id="reason"></input></td>
    </tr>

</table>
<div align="center"><button id="out" value="${user.id}">确认办理</button></div>
</body>
<script>

    $("#out").click(function () {
        var _that = this;
        var id = _that.value;
        var url = "http://localhost:8080/sysUser/updateStatus";
        var status = "2";
        var reason = $(" input[id='reason' ] ").val();
        alert(reason);
        var data = {
            "id":id,
            "status":status,
            "reason":reason
        }
        $.ajax({
            type: "post",
            url: url,
            dataType : "text",
            contentType : "application/json",
            data: JSON.stringify(data),
            success:function (data) {
                //跳转回列表
                var url = "http://localhost:8080/sysUser/findAll"
                window.open(url,'_self');
            }
        });
    });
</script>
</html>


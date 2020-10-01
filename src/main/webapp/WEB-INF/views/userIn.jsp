<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Serving Web Content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<div align="center">新员工入职办理</div>
<br>
<table border="1" align="center">
    <tr>
        <td>姓名</td>
        <td><input id="name"/></td>
    </tr>
    <tr>
        <td>工号</td>
        <td><input id="no"/></td>
    </tr>
    <tr>
        <td>职位</td>
        <td><input id="position"/></td>
    </tr>
</table>
<div align="center">
    <button id="join">保存</button>
</div>
</body>
<script>

    $("#join").click(function () {
        var url = "http://localhost:8080/sysUser/save";
        var name = $(" input[id='name' ] ").val();
        var no = $(" input[id='name' ] ").val();
        var position = $(" input[id='position' ] ").val();
        var data = {
            "name": name,
            "no": no,
            "position": position
        }
        $.ajax({
            type: "post",
            url: url,
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (data) {
                var url = "http://localhost:8080/sysUser/findAll"
                window.open(url, '_self');
                alert(data);

            }
        });
    });
</script>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试文件上传</title>
</head>
<body>
<form action="/upload" method="post" enctype="multipart/form-data">
    <!--值是显示出来的 name是小类型-->
    <input type="file" name="picture">
    <input type="submit" value="上 传">
</form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%

System.out.println("---->>>"+request.getContextPath());

%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0"/>

    <title>Insert title here</title>
</head>
<body>
<h2>上传多个文件 实例</h2>
<form action="/upload/filesUpload" method="post"  enctype="multipart/form-data">
    <p>选择文件:<input type="file" name="files"></p>
    <p>选择文件:<input type="file" name="files"></p>
    <p><input type="submit" value="提交"></p>
</form>
</body>
</html>
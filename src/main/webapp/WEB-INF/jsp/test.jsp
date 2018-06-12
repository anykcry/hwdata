<%@ page contentType="text/html;charset=UTF-8" %>
<%

System.out.println("---->>>"+request.getContextPath());

String path = request.getContextPath();

%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0"/>

    <title>Insert title here</title>

    <script type="text/javascript" src="<%=path%>/js/jquery-3.3.1.min.js"></script>

    <script type="text/javascript">
        function test(){
            alert(1);
            $.ajax({
                url:'<%=path%>/upload/saveFileTest',
                type:'POST',
                data:$('form').serialize(),
                dataType:'json',
                success:function(data){
                    alert("成功！");
                }
            });
        }
    </script>

</head>
<body>
<h2>上传多个文件 实例</h2>
<form id="form">
    <input type="text" name="file[0].fileName" value="jobs"/>
    <input type="text" name="file[0].size" value="55"/><br/>
    <input type="text" name="fileList[1].fileName" value="jim"/>
    <input type="text" name="fileList[1].size" value="21"/><br/>
</form>
<input type="button" onclick="test()" value="提交"/>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: YZQ
  Date: 2019/7/9
  Time: 1:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
    <title>500</title>
</head>
<body>

<h3>糟糕! 服务器出错啦~~(>_<)~~</h3>
<div>
    异常信息如下:<br/>
    ${errorMsg }


</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2022/12/23
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻管理系统</title>
</head>
<body>
<hr color="bisque">
<div>
    <div style="background-color: ghostwhite">
        <div style="width: 50px;float: left;margin: 15px auto auto 60px"><span style="font-family: kaiti;font-size: 25px;color: darkorchid">新闻</span></div>
        [()(https://mp.csdn.net/img/bgimg2.jpg)]
        <span style="color: blue;font-family: kaiti;font-size: 50px;margin-left: 140px">欢迎访问新闻！</span>
        <div style="float: right;margin-right: 100px">
            <ul style="list-style-type: none">
                <li style="display:inline-block"><a href="/News/" style="color: black">首页/</a></li>
                <li style="display:inline-block"><a href="/News/jsp/login.jsp" style="color: black">登录/</a></li>
                <li style="display:inline-block"><a href="/News/jsp/register.jsp" style="color: black">注册</a></li>
            </ul>
        </div>
    </div>

    <h4 ><hr color="bisque"></h4>
    <div align="center">
        <h3>添加评论</h3>
        <form action="/News/addPinLun" method="post">
            评论内容：<textarea name="content" cols="30" rows="10" style="size: 50px"></textarea><br><br><br>
            评论人：<input type="text" name="author"><br><br><br>
            <input type="hidden" name="id" value="${param.id}">
            <input type="submit" value="添加">&emsp;&emsp;
            <input type="button" value="返回" οnclick="location.href='/News/show'">
        </form>
    </div>
</div>
</body>
</html>
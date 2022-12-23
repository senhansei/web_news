<%--
  Created by IntelliJ IDEA.
  User: 86132
  Date: 2022/12/23
  Time: 14:55
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
        [外链图片转存失败(img-lxVzRoGT-1562068507987)(https://mp.csdn.net/img/bgimg2.jpg)]
        <span style="color: blue;font-family: kaiti;font-size: 50px;margin-left: 140px">欢迎访问旧波新闻！</span>
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
        <h3>评论列表</h3>
        <input type="button" value="返回新闻列表页面" οnclick="location.href='/News/show'">
    </div>
    <div align="center">
        <table border="1" cellspacing="1" cellpadding="10">
            <tr>
                <td>评论编号</td>
                <td>评论内容</td>
                <td>评论人</td>
                <td>评论时间</td>
            </tr>
            <c:forEach var="pinglun" items="${sessionScope.list}">
                <tr>
                    <td>${pinglun.id}</td>
                    <td>${pinglun.content}</td>
                    <td>${pinglun.author}</td>
                    <td>${pinglun.createdate}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>

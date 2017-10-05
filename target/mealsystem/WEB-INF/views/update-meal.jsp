<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Dusk
  Date: 2018/4/24
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
        <title>修改Meal</title>

        <!-- 新 Bootstrap 核心 CSS 文件 -->
        <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
<body>
<div class="container">
    <h1>修改 Meal</h1>
    <hr/>
    <sf:form action="/form/meal/updateP" method="post" commandName="mealBean" role="form">
        <div class="form-group">
            <sf:label path="balance">余额:</sf:label>
            <sf:input path="balance" cssClass="form-control" placeholder="修改 余额:" value="${mealBean.balance}"/>
        </div>
        <div class="form-group">
            <sf:label path="userBean.id">用户:</sf:label>
            <sf:select path="userBean.id" class="form-control">
                <c:forEach items="${userBeanList}" var="user">
                    <c:if test="${user.id==mealBean.userBean.id}">
                        <sf:option value="${user.id}" selected="selected">ID：${user.id}, 姓名：${user.username}, 年龄：${user.age}</sf:option>
                    </c:if>
                    <c:if test="${user.id!=mealBean.userBean.id}">
                        <sf:option value="${user.id}">ID：${user.id}, 姓名：${user.username}, 年龄：${user.age}</sf:option>
                    </c:if>
                </c:forEach>
            </sf:select>
        </div>
        <!--把id写入blogP中-->
        <sf:hidden path="id"/>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </sf:form>

</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>

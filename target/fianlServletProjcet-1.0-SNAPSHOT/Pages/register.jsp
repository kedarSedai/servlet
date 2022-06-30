<%--
  Created by IntelliJ IDEA.
  User: kedar
  Date: 6/30/2022
  Time: 5:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="userServlet?page=register" method="POST">
    <div class="container">
        <div class="form-group">
            <label for="exampleInputEmail1">UserName</label>
            <input type="text" name="userName" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                   placeholder="Enter UserName">
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1s">FullName</label>
            <input type="text" name="fullName" class="form-control" id="exampleInputEmail1s"
                   aria-describedby="emailHelp"
                   placeholder="Enter FullName">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" name="password" class="form-control" id="exampleInputPassword1"
                   placeholder="Password">
        </div>
        <a href="index.jsp">Login Page</a>
        <button type="submit" class="btn btn-primary">Register</button>
    </div>
</form>
</body>
</html>

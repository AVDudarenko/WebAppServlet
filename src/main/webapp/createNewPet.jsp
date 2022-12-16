<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 15.12.22
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create pet info</title>
</head>
<body>
<h3>New pet info</h3>
<form method="post">
    <label>Name</label><br>
    <input name="name"/><br><br>
    <label>Age</label><br>
    <input name="age" type="number" max="500"/><br><br>
    <label>Color</label><br>
    <input name="color"/><br><br>
    <label>Owner</label><br>
    <input name="owner"/><br><br>
    <input type="submit" value="Save"/>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 15.12.22
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit pet info</title>
</head>
<body>
<h3>Edit pet info</h3>
<form method="post">
    <input type="hidden" value="${pet.id}" name="id"/>
    <label>Name</label><br>
    <input name="name" value="${pet.name}"/><br><br>
    <label>Age</label><br>
    <input name="age" value="${pet.age}" type="number" min="100"/><br><br>
    <label>Color</label><br>
    <input name="color" value="${pet.color}"/><br><br>
    <label>Owner</label><br>
    <input name="owner" value="${pet.owner}"/><br><br>
    <input type="submit" value="Edit"/>
</form>
</body>
</html>

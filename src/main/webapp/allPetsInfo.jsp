<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 15.12.22
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Products</title>
</head>
<body>
<h2>Pets info</h2>
<p><a href='<c:url value="http://localhost:8080/WebAppServlet_war_exploded/createNewPet"/>'>Create new</a></p>
<table>
  <tr><th>Id</th><th>Name</th><th>Age</th><th>Color</th><th>Owner</th></tr>
  <c:forEach var="pet" items="${pets}">
    <tr>
      <td>${pet.id}</td>
      <td>${pet.name}</td>
      <td>${pet.age}</td>
      <td>${pet.color}</td>
      <td>${pet.owner}</td>
      <td>
        <a href='<c:url value="http://localhost:8080/WebAppServlet_war_exploded/editPetInfo?id=${pet.id}"/>'>Edit</a> |
        <form method="post" action="deletePet" style="display:inline;">
          <input type="hidden" name="id" value="${pet.id}">
          <input type="submit" value="Delete">
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>

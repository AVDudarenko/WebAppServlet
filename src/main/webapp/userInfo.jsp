<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 14.12.22
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User info:</title>
</head>
<body>
<p>Name: <%=request.getParameter("name")%>
</p>
<p>Surname: <%=request.getParameter("surname")%>
</p>
<p>Age: <%=request.getParameter("age")%>
</p>
</body>
</html>

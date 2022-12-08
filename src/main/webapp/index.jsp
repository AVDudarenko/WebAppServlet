<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%
    int parameterValue = Integer.parseInt(request.getParameter("id")) * 2;
    out.println("<p>Count:" + parameterValue + "</p>");
%>

</body>
</html>
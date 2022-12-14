<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 14.12.22
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Name: ${name}</p>
<p>Message: ${message}</p>
<p>Is boolean variable true?</p>
<c:set var="isTrue" value="true"/>
<c:if test="${isTrue == true}">
    <p>Enable</p>
</c:if>
<c:if test="${isTrue == false}">
    <p>Disable</p>
</c:if>
</body>
</html>

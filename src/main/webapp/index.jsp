<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%!
    /**
     * Method who multiply value by ten
     * @param value contains value for multiply
     * @return return result of operation
     */
    int multiplyValue(int value) {
        return value * 10;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<p>
<form action="hello-servlet" method="GET">
    number One: <input name="numberOne"/>
    <br><br>
    number Two: <input name="numberTwo"/>
    <br><br>
    Operation: <input type="radio" name="operation" value="Divide" checked/>Divide
    <input type="radio" name="operation" value="Multiply"/>Multiply
    <input type="radio" name="operation" value="Sum"/>Sum
    <input type="radio" name="operation" value="Subtraction"/>Subtraction
    <br><br>
    <input type="submit" value="Submit"/>
</form>
</p>
<p>
    2+2=  <%= 2 + 2 %>
    2*2=  <%= 2 * 2 %>
    2/2=  <%= 2 / 2 %>
    2-2=  <%= 2 + -2 %>
</p>
<p>
    Results of multiplying by ten:
<ul>
    <%
        //print value ten times
        for (int i = 1; i <= 10; i++) {
            out.println("<li>" + multiplyValue(i) + "</li>");
        }
    %>
</ul>
</p>
</body>
</html>

≈
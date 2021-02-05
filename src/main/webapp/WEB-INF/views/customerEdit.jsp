<%-- 
    Document   : customerForm
    Created on : 3 Φεβ 2021, 8:43:17 μμ
    Author     : Ugleethyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="${pageContext.request.contextPath}/customer/edit" method="GET">
            <label for="ccode">Ccode</label>
            <input id="ccode" type="number" name="ccode">
            <br>
            <label for="cname">Cname</label>
            <input id="cname" type="text" name="cname">
            <br>
            <input type="submit" value="submit">
        </form>
            <a href="${pageContext.request.contextPath}/customer">Back</a>
    </body>
</html>

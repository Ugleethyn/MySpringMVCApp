<%-- 
    Document   : home
    Created on : 2 Φεβ 2021, 9:39:47 μμ
    Author     : Ugleethyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value='/resources/css/style.css' />" rel="stylesheet">
    </head>
    <body>
        <h1>${myMessage}</h1>
        <a href="${pageContext.request.contextPath}/customer">Customers</a><br>
        <a href="${pageContext.request.contextPath}/product">Product</a><br>
        <a href="${pageContext.request.contextPath}/salesman">Salesmen</a>
    </body>
</html>

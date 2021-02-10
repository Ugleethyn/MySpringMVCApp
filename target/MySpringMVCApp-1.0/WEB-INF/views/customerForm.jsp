<%-- 
    Document   : customerForm
    Created on : 3 Φεβ 2021, 8:43:17 μμ
    Author     : Ugleethyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" />
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:if test="${customerToEdit==null}">
            <c:url value="/customer/create" var="link"></c:url>
        </c:if>
        <c:if test="${customerToEdit != null}">
            <c:url value="/customer/update" var="link"></c:url>
        </c:if>
        <form action="${link}" method="POST">
            <input id="ccode" type="text" name="ccode" value="${customerToEdit.ccode}" placeholder="Customer Name"hidden>
            <br>
            <input id="cname" type="text" name="cname" value="${customerToEdit.cname}" placeholder="Customer Name">
            <br>
            <input type="submit" value="submit">
        </form>
        <a href="${pageContext.request.contextPath}/customer">Back</a>
    </body>
</html>

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
            <label for="ccode" hidden>Ccode</label>
            <input id="ccode" type="number" name="ccode" value="${customerToEdit.ccode}" hidden readonly = "true">
            <br>
            <label for="cname">Cname</label>
            <input id="cname" type="text" name="cname" value="${customerToEdit.cname}">
            <br>
            <input type="submit" value="submit">
        </form>
        <a href="${pageContext.request.contextPath}/customer">Back</a>
    </body>
</html>

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
        <h1>Create a product</h1>
        <c:if test="${productToEdit==null}">
            <c:url value="/product/create" var="link"></c:url>
        </c:if>
        <c:if test="${productToEdit != null}">
            <c:url value="/product/update" var="link"></c:url>
        </c:if>
        <form action="${link}" method="POST">
            <input id="pcode" type="number" name="pcode" value="${productToEdit.pcode}" placeholder="ID" hidden="">
            <br>
            <input id="pdescr" type="text" name="pdescr" value="${productToEdit.pdescr}" placeholder="Description">
            <br>
            <input id="pprice" type="number" name="pprice" value="${productToEdit.pprice}" placeholder="Price">
            <br>
            <input type="submit" value="submit">
        </form>
        <a href="${pageContext.request.contextPath}/product">Back</a>
    </body>
</html>

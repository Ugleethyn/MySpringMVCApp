<%-- 
    Document   : customer
    Created on : 3 Φεβ 2021, 8:04:41 μμ
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
        <h1>This is my list with products</h1>
        <div>
            <a href="${pageContext.request.contextPath}/product/create">Add a Product</a>
            <h3>Products</h3>
            <table border="1">
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${listOfProducts}" var = "product" >
                    <tr>
                        <td>${product.pcode}</td>
                        <td>${product.pdescr}</td>
                        <td>${product.pprice}</td>
                        <td><a href="${pageContext.request.contextPath}/customer/edit">Edit</a>/<a href="${pageContext.request.contextPath}/customer/delete">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="${pageContext.request.contextPath}">Back</a>
        </div>
    </body>
</html>

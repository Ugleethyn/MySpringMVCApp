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
        <h1>This is my list with customers</h1>
        <div>
            <p>${message}</p>
            <a href="${pageContext.request.contextPath}/customer/create">Add Customer</a>
            <h3>Customers</h3>
            <table border="1">
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${listOfCustomers}" var = "customer">
                    <tr>
                        <td>${customer.ccode}</td>
                        <td>${customer.cname}</td>
                        <td><a href="${pageContext.request.contextPath}/customer/update/${customer.ccode}">Edit</a>/<a href="${pageContext.request.contextPath}/customer/delete?id=${customer.ccode}">Delete</a></td>
                    </tr>
                    </c:forEach>
            </table>
            <a href="${pageContext.request.contextPath}">Back</a>
            <br>
        </div>
    </body>
</html>

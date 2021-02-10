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
        <h1>This is my list with Salesmen</h1>
        <div>
            <p>${message}</p>
            <a href="${pageContext.request.contextPath}/salesman/create">Add Salesman</a>
            <h3>Customers</h3>
            <table border="1">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>City</th>
                    <th>Commission</th>
                    <th>Actions</th>
                    <th>Family</th>
                </tr>
                <c:forEach items="${listOfSalesmen}" var = "salesman">
                    <tr>
                        <td>${salesman.scode}</td>
                        <td>${salesman.sname}</td>
                        <td>${salesman.scity}</td>
                        <td>${salesman.scomm}</td>
                        <td><a href="${pageContext.request.contextPath}/salesman/update/${salesman.scode}">Edit</a>/<a href="${pageContext.request.contextPath}/salesman/delete?id=${salesman.scode}">Delete</a></td>
                        <td><a href="${pageContext.request.contextPath}/family/${salesman.scode}">Family</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="${pageContext.request.contextPath}">Back</a>
            <br>
        </div>
    </body>
</html>

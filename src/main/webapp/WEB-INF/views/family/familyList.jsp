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
                    <th>Relationship</th>
                    <th>Date Of Birth</th>
                    <th>Actions</th>
                </tr>
                <c:forEach items="${listOfFamily}" var = "family">
                    <tr>
                        <td>${family.fid}</td>
                        <td>${family.fname}</td>
                        <td>${family.frelationship}</td>
                        <td>${family.dob}</td>
                        <td><a href="${pageContext.request.contextPath}/family/update/${family.fid}">Edit</a>/<a href="${pageContext.request.contextPath}/family/delete?id=${family.fid}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="${pageContext.request.contextPath}">Back</a>
            <br>
        </div>
    </body>
</html>

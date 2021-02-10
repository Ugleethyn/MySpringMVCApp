<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create your fantastic salesman</h1>

        <c:if test="${poliths==null}">
            <c:url value="/salesman/create" var="link"/>
        </c:if>
        <c:if test="${poliths!=null}">
            <c:url  value="/salesman/update" var="link"/>
        </c:if>
        <form:form action="${link}" method="POST" modelAttribute="poliths">
            <form:hidden path="scode"/>
            <br/>
            <label for="sname">Name:</label>
            <form:input id="sname" path="sname"/>
            <form:errors path="sname"/>
            <br/>
            <label for="scity">City:</label>
            <form:select id="scity" path="scity">
                <c:forEach items="${listOfCities}" var="city">
                    <form:option value="${city}">${city}</form:option>
                </c:forEach>
            </form:select>
            <br/>
            <label for="scomm">Commission:</label>
            <form:input id="scomm" type="number" step="0.01" path="scomm" />
            <form:errors path="scomm"/>
            <br/>
            <input type="submit" value="Submit"/>
        </form:form>
    </body>
</html>
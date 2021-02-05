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
        <form action="${pageContext.request.contextPath}/product/create" method="POST">
            <label for="pcode">Pcode</label>
            <input id="pcode" type="number" name="pcode">
            <br>
            <label for="pdescr">Pdescr</label>
            <input id="pdescr" type="text" name="pdescr">
            <br>
            <label for="pprice">Price</label>
            <input id="pprice" type="number" name="pprice">
            <input type="submit" value="submit">
        </form>
            <a href="${pageContext.request.contextPath}/product">Back</a>
    </body>
</html>

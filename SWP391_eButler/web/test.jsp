<%-- 
    Document   : test
    Created on : Nov 1, 2022, 3:08:04 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <c:if test="${not empty olist}"><a>Hi, ${user.name} </a><a class="btn btn-primary"  role="button" href="MainController?op=Logout">Logout</a></c:if>
    </body>
</html>

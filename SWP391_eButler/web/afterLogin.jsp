<%-- 
    Document   : afterLogin
    Created on : Sep 26, 2022, 7:23:56 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <body>
        <div class="header">
                <c:if test="${not empty USERLOGIN}"><a>Hi, ${USERLOGIN} </a><a class="btn btn-primary"  role="button" href="LogoutController">Logout</a></c:if>
        </div>
    </body>
</html>

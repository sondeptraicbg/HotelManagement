<%-- 
    Document   : forgotpassword
    Created on : Nov 8, 2022, 1:07:41 AM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
        </style>
    </head>
    <body>
        <h4>Forgot password</h4>
        <form action="forgotpassword" method="post">
            Enterusername: <input type="text" name="username"/>
            <input type="submit" value="Enter"/>
        </form>
        <h4>${requestScope.error}</h4>
    </body>
</html>

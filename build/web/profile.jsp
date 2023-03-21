<%-- 
    Document   : profile
    Created on : Oct 30, 2022, 8:08:28 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="AllCss/profile.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <a style="text-decoration: none; color: #fff;" href="userhome">
            <div class="back-to-home">
                Back to home
            </div>
        </a>

        <div class="head-meeting">
            <h1>Hello ${sessionScope.account.getFirstName()} ${sessionScope.account.getLastName()}</h1>
        </div>

        <div style="margin-bottom: 40px" class="head-meeting">
            <fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>"/>
        </div>

        <div class="information">
            <div class="information-item">
                <span>Date of birth: </span><span>${sessionScope.account.getDateOfBirth()}</span>
            </div>
            <div class="information-item">
                <span>Gender: </span><span>${sessionScope.account.getGender()}</span>
            </div>
            <div class="information-item">
                <span>Email: </span><span>${sessionScope.account.getEmail()}</span>
            </div>
            <div class="information-item">
                <span>Password: </span><span>${sessionScope.account.getPassword()}</span>
            </div>
            <div class="information-item">
                <span>Address: </span><span>${sessionScope.account.getAddress()}</span>
            </div>
            <div class="information-item">
                <span>Phone/Username: </span><span>${sessionScope.account.getGuestID()}</span>
            </div>
        </div>

        <a style="text-decoration: none" href="updateuser?id=${sessionScope.account.getGuestID()}">
            <div class="edit-information">
                <span>Edit information</span>
            </div>
        </a>

    </body>
</html>

<%-- 
    Document   : updateuser
    Created on : Oct 30, 2022, 9:13:44 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="AllCss/profile.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a style="text-decoration: none; color: #fff; margin-bottom: 50px" href="userhome">
            <div class="back-to-home">
                Back to home
            </div>
        </a>
        <form action="updateuser" method="post">

            <div class="information">
                <div class="information-item">
                    <span>First Name: </span><input type="text" name="firstName" value="${requestScope.user.getFirstName()}"/>
                </div>
                <div class="information-item">
                    <span>Last Name: </span><input type="text" name="lastName" value="${requestScope.user.getLastName()}"/>
                </div>
                <div class="information-item">
                    <span>Date of birth: </span><input type="date" name="dateOfBirth" value="${requestScope.user.getDateOfBirth()}"/>
                </div>
                <div class="information-item">
                    <span>Gender: </span><input type="text" name="gender" value="${requestScope.user.getGender()}"/>
                </div>
                <div class="information-item">
                    <span>Email: </span><input type="text" name="email" value="${requestScope.user.getEmail()}"/>
                </div>
                <div class="information-item">
                    <span>Password: </span><input type="text" name="password" value="${requestScope.user.getPassword()}"/>
                </div>
                <div class="information-item">
                    <span>Address: </span><input type="text" name="address" value="${requestScope.user.getAddress()}"/>
                </div>
                <div class="information-item">
                    <span>Phone/Username: </span><input type="text" name="guestID" readonly value="${requestScope.user.getLastName()}"/>
                </div>
            </div>

                <div style="margin: 20px 0 0 50px">
                <input type="submit" value="Submit"/>
            </div>
        </form>
    </body>
</html>

<%-- 
    Document   : updateemployee
    Created on : Nov 2, 2022, 2:23:18 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a style="text-decoration: none; color: #fff; margin-bottom: 50px" href="managehome">
            <div class="back-to-home">
                Back to home
            </div>
        </a>
        <c:set var="e" value="${requestScope.e}"/>
        <form action="updateemployee" method="post">

            <div style="margin-bottom: 20px" class="information">
                <div class="information-item">
                    <span>ID: </span><span>${e.getEmployeeID()}</span>
                </div>
                <div class="information-item">
                    <span>First Name: </span><span>${e.getFirstName()}</span>
                </div>
                <div class="information-item">
                    <span>Last Name: </span><span>${e.getLastName()}</span>
                </div>
                <div class="information-item">
                    <span>Gender: </span><span>${e.getGender()}</span>
                </div>
                <div class="information-item">
                    <span>Date Of Birth: </span><span>${e.getDateOfBirth()}</span>
                </div>
                <div class="information-item">
                    <span>Email: </span><span>${e.getEmail()}</span>
                </div>
                <div class="information-item">
                    <span>Salary: </span><span>${e.getSalary()}</span>
                </div>
                <div class="information-item">
                    <span>Role: </span><span>${e.getRole()}</span>
                </div>
                <div class="information-item">
                    <span>Phone: </span><span>${e.getPhone()}</span>
                </div>
                    <input type="hidden" name="id" value="${requestScope.id}"/>
                <div class="information-item">
                    <span>Status: </span>
                    <select name="newstatus">
                        <option value="Working">Working</option>
                        <option value="On leave">On leave</option>
                        <option value="Out of working">Out of working</option>
                    </select>
                </div>
                <div>
                    <input type="submit" value="Update"/>
                </div>
            </div>
        </form>
    </body>
</html>

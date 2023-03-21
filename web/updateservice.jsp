<%-- 
    Document   : updateservice
    Created on : Nov 7, 2022, 11:07:05 PM
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
        <c:set var="room" value="${requestScope.service}"/>
        <form class="form-box" action="updateservice" method="post">

            <div class="input-box">
                <div>
                    <span>Service ID:</span>
                    <!--<span style="color: red; margin-left: 5px">${requestScope.error}</span><br/>-->
                    <input type="text" name="ServiceCode" placeholder="New RoomID" value="${room.getServiceCode()}" readonly/>
                </div>
                <div>
                    <span>Hotel Code</span><span style="color: red; margin-left: 5px">${requestScope.error}</span><br/>
                    <input type="text" name="hotelCode" value="${room.getHotelCode()}" readonly/>
                </div>
                <div>
                    <span>Name: </span><br/>
                    <input type="text" name="ServiceName" placeholder="Type Of Room" value="${room.getServiceName()}"  required/>
                </div>
                <div>
                    <span>Desc:</span><br/>
                    <input type="text" name="ServiceDes" placeholder="Enter RoomPrice" value="${room.getServiceDes()}" required/>
                </div>
            </div>

            <input class="button" type="submit" value="Apply"/>

        </form>
    </body>
</html>

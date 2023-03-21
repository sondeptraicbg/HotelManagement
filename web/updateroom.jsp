<%-- 
    Document   : updateroom
    Created on : Oct 25, 2022, 8:12:54 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="AllCss/updateroom.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:set var="room" value="${requestScope.room}"/>
        
        <div class="register">
            <div class="register-title">
                <div><span style="font-size: 40px; color: purple; flex: 1">Sign Up</span></div>
            </div>
            <hr>
            <form class="form-box" action="updateroom" method="post">

                <div class="input-box">
                    <div>
                        <span>RoomID</span>
                        <!--<span style="color: red; margin-left: 5px">${requestScope.error}</span><br/>-->
                        <input type="text" name="RoomID" placeholder="New RoomID" value="${room.getRoomID()}" readonly/>
                    </div>
                    <div>
                        <span>Hotel Code</span><span style="color: red; margin-left: 5px">${requestScope.error}</span><br/>
                        <input type="text" name="hotelCode" value="${room.getHotelCode()}" readonly/>
                    </div>
                    <div>
                        <span>Type Of Room</span><br/>
                        <input type="text" name="RoomType" placeholder="Type Of Room" value="${room.getRoomType()}"  required/>
                    </div>
                    <div>
                        <span>Room Price</span><br/>
                        <input type="text" name="RoomPrice" placeholder="Enter RoomPrice" value="${room.getRoomPrice()}" required/>
                    </div>
                    <div>
                        <span>Room Image</span><br/>
                        <input type="text" name="RoomImg" value="${room.getRoomImg()}" required/>
                    </div>
                </div>

                <div class="input-box">
                    <div>
                        <span>Room Describe</span><br/>
                        <input type="text" name="RoomDesc" placeholder="Enter Room Describe" value="${room.getRoomDesc()}" required/>
                    </div>
                    <div>
                        <span>Area</span><br/>
                        <input type="number" name="Area" placeholder="Enter Area" value="${room.getArea()}" required/>
                    </div>
                    <div>
                        <span>Beds In Room</span><br/>
                        <input type="text" name="Bed" placeholder="Enter Beds In Room" value="${room.getBed()}" required/>
                    </div>
                    <div>
                        <span>Direct</span><br/>
                        <input type="text" name="Direct" placeholder="Enter Direct" value="${room.getDirect()}" required/>
                    </div>
                    <div>
                        <span>Available</span><br/>
                        <input type="number" name="Available" placeholder="Enter Available" value="${room.getAvailable()}" required/>
                    </div>
                </div>

                <input class="button" type="submit" value="Apply"/>

            </form>
        </div>
    </body>
</html>

<%-- 
    Document   : addroom
    Created on : Oct 24, 2022, 9:48:49 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="AllCss/addroom.css"/>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="fontawesome-free-6.1.1-web/css/all.min.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="register">
            <div class="register-title">
                <div><span style="font-size: 40px; color: purple; flex: 1">Add room</span></div>
            </div>
            <hr>
            <form class="form-box" action="addroom" method="post">

                <div class="input-box">
                    <div>
                        <span>RoomID</span><span style="color: red; margin-left: 5px">${requestScope.error}</span><br/>
                        <input type="text" name="RoomID" placeholder="New RoomID" value="${param.RoomID}" required/>
                    </div>
                    <div>
                        <span>Hotel Code</span><span style="color: red; margin-left: 5px">${requestScope.error}</span><br/>
                        <input type="text" name="hotelCode" value="${sessionScope.account.getHotelCode()}" readonly/>
                    </div>
                    <div>
                        <span>Type Of Room</span><br/>
                        <input type="text" name="RoomType" placeholder="Type Of Room" value="${param.RoomType}"  required/>
                    </div>
                    <div>
                        <span>Room Price</span><br/>
                        <input type="text" name="RoomPrice" placeholder="Enter RoomPrice" value="${param.RoomPrice}" required/>
                    </div>
                    <div>
                        <span>Room Image</span><br/>
                        <input type="text" name="RoomImg" placeholder="Enter ImgAddress" value="${param.RoomImg}" required/>
                    </div>
                </div>

                <div class="input-box">
                    <div>
                        <span>Room Describe</span><br/>
                        <input type="text" name="RoomDesc" placeholder="Enter Room Describe" value="${param.RoomDesc}" required/>
                    </div>
                    <div>
                        <span>Area</span><br/>
                        <input type="number" name="Area" placeholder="Enter Area" value="${param.Area}" required/>
                    </div>
                    <div>
                        <span>Beds In Room</span><br/>
                        <input type="text" name="Bed" placeholder="Enter Beds In Room" value="${param.Bed}" required/>
                    </div>
                    <div>
                        <span>Direct</span><br/>
                        <input type="text" name="Direct" placeholder="Enter Direct" value="${param.Direct}" required/>
                    </div>
                    <div>
                        <span>Available</span><br/>
                        <input type="number" name="Available" placeholder="Enter Available" value="${param.Available}" required/>
                    </div>
                </div>

                <input class="button" type="submit" value="Add Room"/>

            </form>
        </div>
    </body>
</html>

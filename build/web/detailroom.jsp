<%-- 
    Document   : detailroom
    Created on : Oct 26, 2022, 1:37:32 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="fontawesome-free-6.1.1-web/css/all.min.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
            body{
                font-family: sans-serif;
            }

            .room-item{
                display: flex;
                width: 80%;
                margin: auto;
            }

            .back-button{
                text-align: center;
                width: 200px;
                height: 35px;
                background-color: aqua;
                font-weight: bold;
                border-radius: 10px;
                margin: 5px 0 10px 150px;
                padding-top: 15px;
                padding-left: 5px;
                background-clip: border-box;
            }

            .room-item-book{
                text-align: center;
                width: 200px;
                height: 32px;
                font-weight: bold;
                border-radius: 10px;
                background-clip: border-box;
                background-color: aqua;
                padding-top: 6px;
            }

            .descripe-little-item{
                margin-bottom: 15px;
            }

        </style>
    </head>
    <body>
        <a style="text-decoration: none" href="defaulthome">
            <div class="back-button">
                Back to home
            </div>
        </a>
        <c:set var="r1" value="${requestScope.r1}"/>
        <div class="room-item">
            <div>
                <img id="myImg" class="room-item-img" src="${r1.getRoomImg()}" alt=""/>
            </div>

            <hr/>

            <div>

                <div class="descripe-little">
                    <h5 style="text-align: center">${r1.getRoomType()}</h5>

                    <div class="descripe-little-item"><i class="fa-solid fa-bed"></i>Beds: ${r1.getBed()}</div>
                    <div class="descripe-little-item"><i class="fa-solid fa-street-view"></i>View: ${r1.getDirect()}</div>
                    <div class="descripe-little-item"><i class="fa-sharp fa-solid fa-clone"></i>Area: ${r1.getArea()}</div>
                    <div class="descripe-little-item">
                        <span>Cost without extra services: ${r1.getRoomPrice()} dollars</span>
                    </div>
                    <div class="descripe-little-item">
                        <span>Hotel: ${r1.getHotel().getHotelName()}</span>
                    </div>
                    <div class="descripe-little-item">
                        <span>Describe: ${r1.getRoomDesc()}</span>
                    </div>
                </div>

                <a style="text-decoration: none" href="#">
                    <div class="room-item-book">
                        Book this room
                    </div>
                </a>
            </div>

        </div>    

    </body>
</html>

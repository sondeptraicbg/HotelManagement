<%-- 
    Document   : addservice
    Created on : Nov 7, 2022, 10:32:14 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form class="form-box" action="addservice" method="post">

                <div class="input-box">
                    <div>
                        <span>service code</span><span style="color: red; margin-left: 5px">${requestScope.error}</span><br/>
                        <input type="text" name="servicecode" placeholder="service code" value="${param.RoomID}" required/>
                    </div>
                    <div>
                        <span>Hotel Code</span><span style="color: red; margin-left: 5px">${requestScope.error}</span><br/>
                        <input type="text" name="hotelCode" value="${sessionScope.account.getHotelCode()}" readonly/>
                    </div>
                    <div>
                        <span>Name</span><br/>
                        <input type="text" name="servicename" placeholder="serviceName" value="${param.RoomType}"  required/>
                    </div>
                    <div>
                        <span>Img</span><br/>
                        <input type="text" name="img" placeholder="serviceImg" value="${param.RoomPrice}" required/>
                    </div>
                    <div>
                        <span>Des</span><br/>
                        <input type="text" name="Des" placeholder="serviceDes" value="${param.RoomImg}" required/>
                    </div>
                </div>

                <input class="button" type="submit" value="Add Service"/>

            </form>
    </body>
</html>

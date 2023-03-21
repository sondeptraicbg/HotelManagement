<%-- 
    Document   : employeehome
    Created on : Oct 30, 2022, 10:23:05 PM
    Author     : laptop
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="AllCss/employeehome.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="fontawesome-free-6.1.1-web/css/all.min.css"/>
        <script src="https://cdn.anychart.com/releases/8.0.0/js/anychart-base.min.js"></script>

        <style>
            .logout-button{
                width: 100px;
                height: 20px;
                text-align: center;
                margin-top: 20px;
                margin-bottom: 20px;
                margin: auto;
                border: 2px solid blue;
                border-radius: 10px;
            }
        </style>

    </head>
    <body>
        <button class="tablink" onclick="openPage('Hotel', this, 'orange')">Hotel</button>
        <!--<button class="tablink" onclick="openPage('Overall', this, 'orange')" id="defaultOpen">Overall</button>-->
        <button class="tablink" onclick="openPage('Employee', this, 'orange')" id="defaultOpen">Employee</button>
        <button class="tablink" onclick="openPage('Contact', this, 'orange')">Contact</button>

        <!--tab1-->
        <div id="Hotel" class="tabcontent">

            <a href="logout">
                <div class="logout-button">
                    Logout <i class="fa-solid fa-right-from-bracket"></i>
                </div>
            </a>

            <div>
                <h1>Hello ${sessionScope.account.getFirstName()} ${sessionScope.account.getLastName()}</h1>
                <jsp:useBean id="md" class="dal.manageDAO"/>
                <c:set var="hotelCode" value="${sessionScope.account.getHotelCode()}"/>
                <h1>Welcome ${md.getHotelByHotelCode(hotelCode).getHotelName()}</h1>
            </div>

            <div>
                <fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>"/>
            </div>

            <div class="room-tabb">
                All Room
            </div>


            <!-- Rooms -->
            <div id="room" class="rooms">
                <c:forEach items="${requestScope.listRoom1}" var="r1">
                    <c:set var="id" value="${r1.getRoomID()}"/>
                    <div class="room-item">
                        <img id="myImg" class="room-item-img" src="${r1.getRoomImg()}" alt=""/>
                        <h5 style="text-align: center">${r1.getRoomType()}</h5>

                        <hr/>

                        <div class="descripe-little">
                            <div class="descripe-little-item"><i class="fa-solid fa-bed"></i>Beds: ${r1.getBed()}</div>
                            <div class="descripe-little-item"><i class="fa-solid fa-street-view"></i>View: ${r1.getDirect()}</div>
                            <div class="descripe-little-item"><i class="fa-sharp fa-solid fa-clone"></i>Area: ${r1.getArea()}</div>
                            <div class="descripe-little-item">
                                <span>Cost without extra services: ${r1.getRoomPrice()} dollars</span>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <!--end of rooms to choose-->

            <div class="service-tabb">
                All Services
            </div>

            <!-- Services -->
            <div id="service" class="list-service">
                <c:forEach items="${requestScope.listService}" var="s">
                    <div class="service-item">
                        <div class="service-item-img">
                            <img class="service-img" src="${s.getServiceImg()}" alt=""/>
                        </div>

                        <div class="service-descripe-little">
                            <div class="service-descripe-little-item-name">${s.getServiceName()}</div>
                            <div class="service-descripe-little-item-desc">${s.getServiceDes()}</div>
                        </div>

                    </div>
                </c:forEach>
            </div>
            <!-- End Services -->
        </div>
<!--
        Overall tab2
        <div id="Overall" class="tabcontent">
            <div id="container" style="width: 100%; height: 100%"></div>
            <script>
                anychart.onDocumentReady(function () {

                    // set the data
                    var data = {
                        header: ["Name", "Death toll"],
                        rows: [
                            ["San-Francisco (1906)", 1500],
                            ["Messina (1908)", 87000],
                            ["Ashgabat (1948)", 175000],
                            ["Chile (1960)", 10000],
                            ["Tian Shan (1976)", 242000],
                            ["Armenia (1988)", 25000],
                            ["Iran (1990)", 50000]
                        ]};

                    // create the chart
                    var chart = anychart.bar();

                    // add the data
                    chart.data(data);

                    // set the chart title
                    chart.title("The deadliest earthquakes in the XXth century");

                    // draw
                    chart.container("container");
                    chart.draw();
                });
            </script>
        </div>-->

        <!--tab3-->
        <div id="Employee" class="tabcontent">

            <div style="margin-bottom: 40px" class="head-meeting">
                <fmt:formatDate pattern="dd/MM/yyyy" value="<%= new java.util.Date()%>"/>
            </div>

            <div class="information">
                <div class="information-item">
                    <span>Your ID: </span><span>${sessionScope.account.getEmployeeID()}</span>
                </div>
                <div class="information-item">
                    <span>Hotel Code: </span><span>${sessionScope.account.getHotelCode()}</span>
                </div>
                <div class="information-item">
                    <span>First Name: </span><span>${sessionScope.account.getFirstName()}</span>
                </div>
                <div class="information-item">
                    <span>Last Name: </span><span>${sessionScope.account.getLastName()}</span>
                </div>
                <div class="information-item">
                    <span>Gender: </span><span>${sessionScope.account.getGender()}</span>
                </div>
                <div class="information-item">
                    <span>Date Of Birth: </span><span>${sessionScope.account.getDateOfBirth()}</span>
                </div>
                <div class="information-item">
                    <span>Email: </span><span>${sessionScope.account.getEmail()}</span>
                </div>
                <div class="information-item">
                    <span>Salary: </span><span>${sessionScope.account.getSalary()}</span>
                </div>
                <div class="information-item">
                    <span>Role: </span><span>${sessionScope.account.getRole()}</span>
                </div>
                <div class="information-item">
                    <span>Password: </span><span>${sessionScope.account.getPassword()}</span>
                </div>
                <div class="information-item">
                    <span>Phone: </span><span>${sessionScope.account.getPhone()}</span>
                </div>
            </div>

        </div>

        <!--tab4-->
        <div id="Contact" class="tabcontent">
            <table style="border: 1px solid">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Content</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${requestScope.listContact}" var="c">
                    <form action="feedback">
                        <tr>
                            <td>${c.getId()}</td>
                            <td>${c.getName()}</td>
                            <td>${c.getGmail()}</td>
                            <td>${c.getContent()}</td>
                            <td>${c.isIsReplied()}</td>
                            <td>
                                <c:if test="${c.isIsReplied() == false }">
                                    <a href="contactus?id=${c.getId()}">
                                        <div>
                                            Open
                                        </div>
                                    </a>
                                </c:if>
                                <c:if test="${c.isIsReplied() == true }">
                                    <span>No action</span>
                                </c:if>
                            </td>
                        </tr>
                    </form>

                </c:forEach>
            </table>
        </div>
        <!--end-->

        <script src="AllJs/managehome.js"></script>

    </body>
</html>

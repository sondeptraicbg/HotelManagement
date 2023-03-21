<%-- 
    Document   : managehome
    Created on : Oct 24, 2022, 1:14:23 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <link rel="stylesheet" href="AllCss/managehome.css"/>
        <link rel="stylesheet" href="fontawesome-free-6.1.1-web/css/all.min.css"/>
        <script src="https://cdn.anychart.com/releases/8.0.0/js/anychart-base.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
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
        <button class="tablink" onclick="openPage('Overall', this, 'orange')" id="defaultOpen">Overall</button>
        <button class="tablink" onclick="openPage('Employee', this, 'orange')">Contact and History</button>
        <button class="tablink" onclick="openPage('Client', this, 'orange')">Employee</button>

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

            <div>
                <a style="text-decoration: none" href="checklogin?action=add">
                    <div class="add-button">
                        <span>Add Room</span>
                    </div>
                </a>
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
                        <a href="checklogin?action=update&id=${id}">
                            <div class="update-room">
                                Update
                            </div>
                        </a>
                        <a href="checklogin?action=delete&id=${id}">
                            <div class="delete-room">
                                Delete
                            </div>
                        </a>

                    </div>
                </c:forEach>
            </div>
            <!--end of rooms to choose-->

            <div class="service-tabb">
                All Services
            </div>

            <!-- Services -->
            <div id="service" class="list-service">
                <div>
                    <a style="text-decoration: none" href="checkloginservice?action=add">
                        <div>
                            <span>Add Service</span>
                        </div>
                    </a>
                </div>
                <c:forEach items="${requestScope.listService}" var="s">
                    <c:set var="idser" value="${s.getServiceCode()}"/>
                    <div class="service-item">
                        <div class="service-item-img">
                            <img class="service-img" src="${s.getServiceImg()}" alt=""/>
                        </div>

                        <div class="service-descripe-little">
                            <div class="service-descripe-little-item-name">${s.getServiceName()}</div>
                            <div class="service-descripe-little-item-desc">${s.getServiceDes()}</div>
                        </div>

                        <div>
                            <a href="checkloginservice?action=update&id=${idser}">
                                <div>
                                    Update
                                </div>
                            </a>
                            <a href="checkloginservice?action=delete&id=${idser}">
                                <div>
                                    Delete
                                </div>
                            </a>
                        </div>


                    </div>
                </c:forEach>
            </div>
            <!-- End Services -->
        </div>

        <!--Overall-->
        <div id="Overall" class="tabcontent">

            <div>
                <h2>Total booking by 6 earlyest months</h2>
            </div>

            <div class="overall-item">
                <div id="container" style="width: 100%; min-height: 100%"></div>

                <script>
                    anychart.onDocumentReady(function () {

                        // set the data
                        var data = {
                            header: ["Name", "Sum: "],
                            rows: [
                                //                            ["San-Francisco (1906)", 1500],
                                //                            ["Messina (1908)", 87000],
                                //                            ["Ashgabat (1948)", 175000],
                                //                            ["Chile (1960)", 10000],
                                //                            ["Tian Shan (1976)", 242000],
                                //                            ["Armenia (1988)", 25000],
                                //                            ["Iran (1990)", 50000]
                    <c:forEach items="${requestScope.monthly}" var="m">
                                [${m.getMonth()}, ${m.getVolume()}],
                    </c:forEach>

                            ]}
                        ;

                        // create the chart
                        var chart = anychart.bar();

                        // add the data
                        chart.data(data);

                        // set the chart title
//                        chart.title("Total booking by 6 earlest months");

                        // draw
                        chart.container("container");
                        chart.draw();
                    });
                </script>


            </div>

            <div>
                <h2>Total booking by price last month</h2>
            </div>

            <div class="overall-item">
                <canvas id="myChart1" style="width:100%;max-width:600px"></canvas>

                <script>
                    var xValues = [
                    <c:forEach items="${requestScope.monthNice}" var="m">
                        ${m.getMonth()},
                    </c:forEach>];
                    var yValues = [<c:forEach items="${requestScope.monthNice}" var="m">
                        ${m.getVolume()},
                    </c:forEach>
                    ];

                    new Chart("myChart1", {
                        type: "line",
                        data: {
                            labels: xValues,
                            datasets: [{
                                    fill: false,
                                    lineTension: 0,
                                    backgroundColor: "rgba(0,0,255,1.0)",
                                    borderColor: "rgba(0,0,255,0.1)",
                                    data: yValues
                                }]
                        },
                        options: {
                            legend: {display: false},
                            scales: {
                                yAxes: [{ticks: {min: 0, max: 16}}],
                            }
                        }
                    });
                </script>
            </div>

            <div>
                <h2>Total booking by types last month</h2>
            </div>

            <div class="overall-item">
                <canvas id="myChart2" style="width:100%;max-width:600px"></canvas>

                <script>
                    var xValues = [
                        "Deluxe", "VIP", "Double Room", "Stadard", "Suite", "Stadard Room"
                    ];
                    var yValues = [
                    <c:forEach items="${requestScope.monthType}" var="h">
                        ${h.getVolume()},
                    </c:forEach>
                    ];
                    var barColors = ["red", "green", "blue", "orange", "brown", "red"];

                    new Chart("myChart2", {
                        type: "bar",
                        data: {
                            labels: xValues,
                            datasets: [{
                                    backgroundColor: barColors,
                                    data: yValues
                                }]
                        },
                        options: {
                            legend: {display: false},
                            title: {
                                display: false,
                                text: ""
                            }
                        }
                    });
                </script>
            </div>

        </div>

        <!--Contact-->
        <div id="Employee" class="tabcontent">
            <table style="border: 1px solid; margin-bottom: 50px">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Content</th>
                    <th>Status</th>
                </tr>
                <c:forEach items="${requestScope.listContact}" var="c">
                    <form action="feedback">
                        <tr>
                            <td>${c.getId()}</td>
                            <td>${c.getName()}</td>
                            <td>${c.getGmail()}</td>
                            <td>${c.getContent()}</td>
                            <td>${c.isIsReplied()}</td>

                        </tr>
                    </form>

                </c:forEach>
            </table>
            
            <h1>History</h1>
            <form action="searchguest">
                Enter name:
                <input type="text" name="nameguest"/>
                <input type="submit" value="Search"/>
            </form>
            
            <c:forEach items="${requestScope.listBooking}" var="e">
                <div style="margin-bottom: 20px" class="information">
                    <div class="information-item">
                        <span>Booking ID: </span><span>${e.getBookingID()}</span>
                    </div>
                    <div class="information-item">
                        <span>Hotel Code: </span><span>${e.getHotelCode()}</span>
                    </div>
                    <div class="information-item">
                        <span>Guest ID: </span><span>${e.getGuestName()}</span>
                    </div>
                    <div class="information-item">
                        <span>RoomID: </span><span>${e.getRoom().getRoomID()}</span>
                    </div>
                    <div class="information-item">
                        <span>Booking Date: </span><span>${e.getBookingDate()}</span>
                    </div>
                    <div class="information-item">
                        <span>Special Request: </span><span>${e.getSpecialReq()}</span>
                    </div>
                    <div class="information-item">
                        <span>Type: </span><span>${e.getType()}</span>
                    </div>
                    <div class="information-item">
                        <span>End Date: </span><span>${e.getEndDate()}</span>
                    </div>
                    
                </div>
            </c:forEach>
        </div>

        <!--employee-->
        <div id="Client" class="tabcontent">
            <c:forEach items="${requestScope.listEm}" var="e">
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
                    <div class="information-item">
                        <span>Status: </span><span>${e.getStatus()}</span>
                    </div>
                    <div>
                        <a href="updateemployee?id=${e.getEmployeeID()}">
                            <div class="editemployee?id=${e.getEmployeeID()}">
                                Update information
                            </div>
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <script src="AllJs/managehome.js"></script>

    </body>
</html>

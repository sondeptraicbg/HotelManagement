<%-- 
    Document   : home
    Created on : Oct 11, 2022, 11:33:08 AM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="AllCss/home.css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="fontawesome-free-6.1.1-web/css/all.min.css"/>

        <script src="AllJs/jsHome.js"></script>
        <style>
            .pagination{
                display: inline-block;
                border: 1px solid #ccc;
                height: 60px;
                padding-top: 10px;
            }
            
            .pagination a{
                color: black;
                font-size: 22px;
                padding: 8px 16px;
                text-decoration: none;
            }
            
            .pagination a.active{
                background-color: #ccc;
                color: #fff;
            }
            
            .pagination a:hover:not(.active){
                background-color: blueviolet;
            }
        </style>
    </head>
    <body>

        <header id="header">
            <div id="tophead" class="navbar">
                <div class="icon">
                    <!--<h2 class="logo">this is logo</h2>-->
                    <a class="hotel-icon" href="#">
                        <i class="fa-solid fa-hotel">M</i>
                    </a>
                </div>

                <div class="menu">
                    <ul class="memu-list">
                        <li class="memu-list-item"><a href="#tophead">HOME</a></li>
                        <li class="memu-list-item"><a href="#contactus">CONTACT</a></li>
                        <li class="memu-list-item"><a href="login">LOGIN</a></li>
                    </ul>
                </div>

                <div style="display: flex" class="where-are-you">
                    <span style="color: #fff">Where are you?</span>
                    <form action="defaulthome" method="post">
                        <select name="chooseCity" onchange="this.form.submit()">
                            <option value="n">Choose City</option>
                            <option value="Ha Noi">Ha Noi</option>
                            <option value="Da Nang">Da Nang</option>
                            <option value="Ho Chi Minh">Ho Chi Minh</option>
                            <option value="Nha Trang">Nha Trang</option>
                        </select>    
                    </form>

                </div>

            </div>
        </header>
        <!--end of header-->

        <div id="intro-imgs">
            <div style="margin-top: 60px">
                <h1 class="intro-imgs-content">Welcome to our hotel</h1>
            </div>
        </div>
        <!--end of imgs intro-->

        <div style="background-color: #1F274D; text-align: center; height: 50px; padding-top: 20px">
            <h2 style="color: #fff">${requestScope.in}</h2>
        </div>

        <div style="background-color: #fff; text-align: center; padding-top: 20px">
            <h4 style="color: #000">To easily use the service and receive offers,
                <span style="color: #498BEC"><a href="login">login</a></span>, or <span style="color: #498BEC"><a href="register">register</a></span></h4>
        </div>

        <!-- Tab links -->
        <div style="padding-left: 42px" class="tab">
            <button class="tablinks" onclick="openCity(event, 'room')" id="defaultOpen">Room</button>
            <button class="tablinks" onclick="openCity(event, 'service')">Service</button>
            <button class="tablinks" onclick="openCity(event, 'hotel')">Hotel</button>
        </div>

        <div class="choose-date-and-price">
            <!-- Choose Price -->
            <div style="display: flex" class="choose-price">
                <div class="choose-price-item">
                    <form action="search">
                        <input type="hidden" name="city" value="${param.chooseCity}"/>
                        <span>Choose Area of Price</span>
                        <select name="choosePrice" onchange="this.form.submit()">
                            <option value="n">Choose Price</option>
                            <option value="0,30">30 or smaller</option>
                            <option value="30,50">30 to 50</option>
                            <option value="50,75">50 to 75</option>
                            <option value="75,120">75 or grater</option>
                        </select><br/>

                        <span>Enter max price: </span>
                        <input type="number" placeholder="Enter price" name="maxPrice"/>
                        <input type="submit" value="Search"/>
                    </form>
                </div>

                <div class="choose-price-item1">
                    <form action="search" method="post">
                        <span>Arrange from:</span><br/>
                        <input type="radio" name="arrange" value="low"/><span style="margin-right: 15px">Low</span>
                        <input type="radio" name="arrange" value="high"/><span style="margin-right: 15px">High</span>
                        <input type="submit"  value="Arrange"/>
                    </form>
                </div>

            </div>
            <!--End choose price-->

        </div>


        <!-- Rooms -->
        <div id="room" class="tabcontent rooms">
            <c:forEach items="${requestScope.listRoom1}" var="r1">
                <a style="color: black" href="detailroom?id=${r1.getRoomID()}">
                    <div class="room-item">
                        <img id="myImg" class="room-item-img" src="${r1.getRoomImg()}" alt=""/>
                        <h5 style="text-align: center">${r1.getRoomType()}</h5>

                        <hr/>

                        <div class="descripe-little">
                            <div class="descripe-little-item"><i class="fa-solid fa-bed"></i>Beds: ${r1.getBed()}</div>
                            <div class="descripe-little-item"><i class="fa-solid fa-street-view"></i>View: ${r1.getDirect()}</div>
                            <div class="descripe-little-item"><i class="fa-sharp fa-solid fa-clone"></i>Area: ${r1.getArea()}</div>
                            <!--                        <div class="descripe-little-item">
                                                        <span>Cost without extra services: ${r1.getRoomPrice()} dollars</span>
                                                    </div>-->
                            <div class="descripe-little-item">
                                <span>Hotel: ${r1.getHotel().getHotelName()}</span>
                            </div>
                        </div>
                        <a href="takebook?id=${r1.getRoomID()}&num=1">
                            <div class="room-item-book">
                                Book this room
                            </div>
                        </a>
                    </div>    
                </a>

            </c:forEach>
            
            <c:set var="numP" value="${requestScope.page}"/>
            <div class="pagination">
                <div style="margin: 0 0 10px 20px; font-weight: bold">Page</div>
                <c:forEach begin="${1}" end="${requestScope.num}" var="i">
                    <a class="${i==page?"active":""}" href="defaulthome?page=${i}">
                        ${i}
                    </a>
                </c:forEach>
            </div>
        </div>
        <!--end of rooms to choose-->

        <!-- Services -->
        <div id="service" class="list-service tabcontent">
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

        <!-- Hotels -->
        <div id="hotel" style="display: block" class="list-hotel tabcontent">
            <c:forEach items="${requestScope.listHotel}" var="h">
                <div class="hotel-item">
                    <div class="hotel-item-img">
                        <img class="hotel-img" src="${h.getHotelImg()}" alt=""/>
                    </div>

                    <div class="hotel-infor">
                        <div class="hotel-descripe">
                            <div style="margin-bottom: 20px" class="service-descripe-name">${h.getHotelName()}</div>
                            <div style="margin-bottom: 20px" class="service-descripe-location">Location: ${h.getLocation()}</div>
                            <div style="margin-bottom: 20px" class="service-descripe-numroom">Volumn: ${h.getNumRooms()}</div>
                        </div>

                        <div class="hotel-descripe">
                            <div style="margin-bottom: 20px" class="service-descripe-city">City: ${h.getCity()}</div>
                            <div style="margin-bottom: 20px" class="service-descripe-phone">Phone: ${h.getPhone()}</div>
                            <div style="margin-bottom: 20px" class="service-descripe-star">Star Rating: ${h.getStarRating()}/5</div>

                        </div>
                        <div style="text-decoration:none; overflow:hidden;max-width:100%;width:250px;height:250px; flex: 1"><div id="google-maps-canvas" style="height:100%; width:100%;max-width:100%;"><iframe style="height:100%;width:100%;border:0;" frameborder="0" 
                                                                                                                                                                                                        src="${h.getMap()}">
                                </iframe></div><a class="google-maps-html" href="https://www.bootstrapskins.com/themes" id="make-map-infor-mation">premium bootstrap themes</a><style>#google-maps-canvas img.text-marker{
                                    max-width:none!important;
                                    background:none!important;
                                }
                                img{
                                    max-width:none
                                        }</style></div>

                    </div>

                </div>
            </c:forEach>
        </div>
        <!-- End Hotel -->

        <footer>
            <div id="contactus" class="contact-us">
                <h1 style="text-align: center">Contact us</h1>
                <p style="text-align: center">My rich dad used to say,<br/>“You can never have true freedom without financial freedom.”</p>
            </div>

            <div class="to-contact">
                <div class="to-contact-info">
                    <h2>Contact info</h2>
                    <h3>Amazing hotel, Inc.</h3>
                    <h3>123 Tran Duy Hung Street</h3>
                    <h3>Ha Noi, Viet Nam</h3>
                    <h3>P: (123) 4567-890</h3>
                </div>

                <div class="to-contact-message">
                    <form action="">
                        <input class="footer-input" type="text" name="name" placeholder="name"/><br/>
                        <input class="footer-input" type="text" name="email" placeholder="Email"/><br/>
                        <input class="footer-input footer-input-mes" type="text" name="message" placeholder="Message"/><br/>

                        <input type="submit" value="Send Message"/>
                    </form>
                </div>
            </div>
        </footer>
        <!--end footer-->

        <script>
            function openCity(evt, cityName) {
                // Declare all variables
                var i, tabcontent, tablinks;

                // Get all elements with class="tabcontent" and hide them
                tabcontent = document.getElementsByClassName("tabcontent");
                for (i = 0; i < tabcontent.length; i++) {
                    tabcontent[i].style.display = "none";
                }

                // Get all elements with class="tablinks" and remove the class "active"
                tablinks = document.getElementsByClassName("tablinks");
                for (i = 0; i < tablinks.length; i++) {
                    tablinks[i].className = tablinks[i].className.replace(" active", "");
                }

                // Show the current tab, and add an "active" class to the button that opened the tab
                document.getElementById(cityName).style.display = "flex";
                evt.currentTarget.className += " active";
            }
            document.getElementById("defaultOpen").click();
        </script>
    </body>
</html>

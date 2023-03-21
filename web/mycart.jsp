<%-- 
    Document   : mycart
    Created on : Oct 28, 2022, 5:57:34 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="AllCss/mycart.css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div class="title-cart">
            <h1>List of rooms is pending</h1>
        </div>

        <div>
            <c:if test="${requestScope.size == 0}">
                <div class="no-room">
                    <div  id="empty-cart">
                        <img class="empty-cart-img" src="imgs/2038854.png" alt="empty-cart"/>
                    </div>

                    <div class="no-room-title">
                        <h1>There is no room is waiting for payment</h1>
                    </div>
                </div>
            </c:if>
            <c:if test="${requestScope.size > 0}">
                <div class="table-room">
                    <table style="border: 1px solid">
                        <tr>
                            <th>No</th>
                            <th>Type</th>
                            <th>Image</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Total</th>
                            <th>Action</th>
                        </tr>
                        <c:set var="o" value="${requestScope.cart}"/>
                        <c:set var="no" value="0"/>
                        <c:forEach items="${o.booking}" var="b">
                            <c:set var="no" value="${no+1}"/>
                            <tr>
                                <td>${no}</td>
                                <td>${b.getRoom().getRoomType()}</td>
                                <td><img class="room-item-img" src="${b.getRoom().getRoomImg()}" alt=""/></td>
                                <td>
                                    <button><a style="text-decoration: none" href="process?num=-1&id=${b.getRoom().getRoomID()}">-</a></button>
                                    ${b.quantity}
                                    <button><a style="text-decoration: none" href="process?num=1&id=${b.getRoom().getRoomID()}">+</a></button>
                                </td>
                                <td>${b.room.getRoomPrice()} per night or day</td>
                                <td>${(b.room.getRoomPrice()) * (b.quantity)}</td>
                                <td>
                                    <form action="process" method="post">
                                        <input type="hidden" name="id" value="${b.getRoom().getRoomID()}"/>
                                        <input type="submit" value="return"/>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <h3>Total Money:$ ${o.getTotalMoney()}</h3>
                    <hr>
                    <form action="checkout" method="post">
                        <!-- Choose Date -->
                        <div style="display: flex" class="choose-date">
                            <div class="checkout-item">
                                <span style="padding-top: 6px">Choose arrival date: </span><input type="date" name="fromDate" required/>
                                <span style="padding-top: 6px; margin-left: 10px">Choose check out date: </span><input type="date" name="toDate" required/>
                            </div>
                            <div  style="height: 100px" class="checkout-item">
                                Special request: <textarea style="height: 100%; width: 50%;" name="spcReq" ></textarea>
                            </div>
                            <div class="checkout-item">
                                <span style="padding-top: 8px;">Checkout:  </span>
                                <input style="padding-top: 6px;margin-right: 10px" name="via" type="radio" value="Bank" required/><span style="padding-top: 8px; margin-right: 10px">Bank</span>
                                <input style="padding-top: 6px;margin-right: 10px" name="via" type="radio" value="Visa" required/><span style="padding-top: 8px; margin-right: 10px">Visa</span>
                                <input style="padding-top: 6px;margin-right: 10px" name="via" type="radio" value="Cash" required/><span style="padding-top: 8px; margin-right: 10px">Cash</span>
                            </div>

                        </div>

                        <!--End choose date-->
                        <input type="submit" value="CheckOut"/>
                    </form>
                </div>
            </c:if>

            <a style="text-decoration: none; color: #fff;" href="userhome">
                <div class="continue-booking">
                    Continue booking
                </div>
            </a>
        </div>

    </body>
</html>

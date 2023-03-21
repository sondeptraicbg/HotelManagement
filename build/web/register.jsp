<%-- 
    Document   : register
    Created on : Oct 16, 2022, 8:40:32 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="AllCss/register.css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        
    </head>
    <body>

        <div class="register">
            <div class="register-title">
                <div><span style="font-size: 40px; color: purple; flex: 1">Sign Up</span></div>
            </div>
            <hr>
            <form class="form-box" action="register" method="post">

                <div class="input-box">
                    <div>
                        <span>GuestID</span><span style="color: red; margin-left: 5px">${requestScope.error}</span><br/>
                        <input type="text" name="GuestID" placeholder="Your Phone Number" value="${param.GuestID}" required/>
                    </div>
                    <div>
                        <span>First Name</span><br/>
                        <input type="text" name="FirstName" placeholder="Enter your First Name" value="${param.FirstName}"  required/>
                    </div>
                    <div>
                        <span>Last Name</span><br/>
                        <input type="text" name="LastName" placeholder="Enter your Last Name" value="${param.LastName}" required/>
                    </div>
                    <div>
                        <span>Date Of Birth</span><br/>
                        <input type="date" name="DOB" value="${param.DOB}" required/>
                    </div>
                </div>

                <div class="input-box">
                    <div>
                        <span>Gender</span><br/>
                        <!--                        <select name="Gender">
                                                    <option value="Male">Male</option>
                                                    <option value="Female">Female</option>
                                                </select>-->
                        <div>
                            <input style="height: 16px; width:16px" type="radio" name="Gender"/><span>Male</span>
                            <input style="height: 16px; width:16px" class="gender" type="radio" name="Gender"/><span>Female</span>
                        </div>
                    </div>
                    <div>
                        <span>Email</span><br/>
                        <input type="text" name="Email" placeholder="Enter your Email" value="${param.Email}" required/>
                    </div>
                    <div>
                        <span>Password</span><br/>
                        <input type="password" name="Password" placeholder="Enter your Password" value="${param.Password}" required/>
                    </div>
                    <div>
                        <span>Address</span><br/>
                        <input type="text" name="Address" placeholder="Enter your Address" value="${param.Address}" required/>
                    </div>
                </div>

                <input class="button" type="submit" value="Register"/>

            </form>
        </div>

    </body>
</html>

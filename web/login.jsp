<%-- 
    Document   : login
    Created on : Oct 11, 2022, 9:27:57 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="AllCss/login.css"/>
        <link rel="stylesheet" href="fontawesome-free-6.1.1-web/css/all.min.css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>

        <form action="login" method="post">

            <div id="login">
                <div class="login-title">
                    <div><span style="font-size: 40px; color: purple; flex: 1">Login</span></div>
                </div>
                <hr>
                <div class="login-form">
                    <!-- username and password -->
                    <div style="border-bottom: 2px solid #adadad" class="information"><label>Username</label><span style="color: red; margin-left: 2px">${requestScope.error}</span>
                        <input type="text" name="username" placeholder="Your Username" value="${param.username}" required/><br/></div>
                    <div class="information"><label>Password</label><input type="password" name="password" placeholder="Your Password" value="${param.password}"/><br/></div>
                    
                    
                    <h4 ><a class="remember" href="forgotpassword">Forget password?</a></h4>
                    <h4 >${requestScope.suggestions}</h4>
                    
                    <!-- role -->
                    <span>Login as </span>
                    <select name="role" id="role">
                        <option value="manager">Manager</option>
                        <option value="employee">Employee</option>
                        <option value="user">User</option>
                    </select><br/>

                    <!-- remember and submit -->
                    <input type="checkbox" value="on" name="remember"/>Remember password<br/>
                    
                    <input class="login-button" type="submit" value="Login"/>
                    <!--<input type="submit" value="Login"/>-->
                </div>
            </div>
        </form>


    </body>
</html>


<%-- 
    Document   : takefeedback
    Created on : Oct 31, 2022, 1:21:16 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <style>
            body{
                font-family: sans-serif;
            }

            .back-to-home{
                background-color: #1F274D;
                text-align: center;
                padding: 20px;
                width: 20%;
                margin: auto;
                border-radius: 10px;
            }
            .information{
                border: 2px solid #ccc;
                padding: 20px;
                padding-top: 40px;
                border-radius: 10px;
                width: 60%;
                margin-left: 50px;
            }

            .information-item{
                margin-bottom: 20px;
            }

            .information-item span{
                min-width: 100px;
            }
        </style>
    </head>
    <body>
        <a style="text-decoration: none; color: #fff;" href="employeehome">
            <div style="margin-bottom: 50px" class="back-to-home">
                Back to home
            </div>
        </a>

        <form action="contactus" method="post">
            <div class="information">

                <div class="information-item">
                    <span>ID of contact: </span><span>${requestScope.contact.getId()}</span>
                    <input type="hidden" name="id" value="${requestScope.contact.getId()}"/>
                </div>
                <div class="information-item">
                    <span>Email: </span><span>${requestScope.contact.getGmail()}</span>
                    <input type="hidden" name="email" value="${requestScope.contact.getGmail()}"/>
                </div>
                <div class="information-item">
                    <span>Content: </span><span>${requestScope.contact.getContent()}</span>
                    <input type="hidden" name="content" value="${requestScope.contact.getContent()}"/>
                </div>
                <div class="information-item">
                    <span>Name: </span><span>${requestScope.contact.getName()}</span>
                    <input type="hidden" name="name" value="${requestScope.contact.getName()}"/>
                </div>
                <div class="information-item">
                    <span>Feedback: </span><br/>
                    <textarea style="width: 70%; height: 100px" name="fb"></textarea>
                </div>
                <div class="information-item">
                    <input type="submit" value="Send feedback"/>
                </div>
            </div>

        </form>

    </body>
</html>

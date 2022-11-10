<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 01-Nov-22
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Marjane BackOffice</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=application.getInitParameter("url")%>styles/base.css">
    <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdn.jsdelivr.net/npm/@tailwindcss/custom-forms@0.2.1/dist/custom-forms.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<%--<div class="">--%>
<%
    String role = (String)request.getSession().getAttribute("role");
    Map<String, String> headerTitles =((Map)request.getSession().getAttribute("headerTitles"));
%>
<%--</div>--%>
<div class="w-full relative flex min-h-screen flex-col justify-center">
    <nav class="w-full fixed top-0 bg-gray-50 z-[999]">
            <div class="max-h-28 w-full ml-12 mr-0 grid grid-flow-col sm:grid-cols-5">
                <div class="">
                    <img  class="w-20 h-20"  src="<%=application.getInitParameter("url")%>assets/logo_marjane.svg"/>
                </div>
                <div class="hidden sm:flex justify-start items-center text-center select-none font-semibold col-span-3">
                    <h4><%= headerTitles.get(role)%></h4>
                </div>
                <div class="relative flex justify-end items-center rounded-full sm:px-4 mr-4" onclick="showProfileIconMenu()">
                    <lottie-player src="https://assets6.lottiefiles.com/packages/lf20_cz6ukw4q.json" class="cursor-pointer h-20 w-24 mr-8"
                                   background="transparent" speed="1" loop autoplay></lottie-player>
                    <div class="absolute top-14 right-14 z-[999] hidden flex justify-center items-center p-3" id="userIconMenu">
                        <ul class="list-none block bg-white border rounded-md w-[200px]">
                            <li class="p-3 text-center hover:bg-gray-50">
                                Profile
                            </li>
                            <li class="p-3 text-center hover:bg-gray-50">
                                <a href="<%=application.getInitParameter("url")%>LogoutServlet">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
    </nav>

<%--</div>--%>

    <script>
        function showProfileIconMenu() {
            let userIconMenu = document.getElementById("userIconMenu");
            if (userIconMenu.style.display === "block") {
                userIconMenu.style.display = "none";
            } else {
                userIconMenu.style.display = "block";
            }
        }
    </script>
</body>
</html>

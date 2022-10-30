<!-- <%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 30-Oct-22
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<html>
<head>
    <title>LoginPage</title>
    <link rel="stylesheet" href="../styles/base.css">
    <script src="https://unpkg.com/@lottiefiles/lottie-player@latest/dist/lottie-player.js"></script>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
<div class="w-full relative flex min-h-screen flex-row justify-center overflow-hidden bg-gray-50 py-6 px-4 sm:py-12">
    <div class="w-full bg-grey-50 hidden sm:flex flex justify-content-center align-items-center">
        <lottie-player src="https://assets6.lottiefiles.com/packages/lf20_7iJBrlAASd.json" class="text-center" background="transparent"  speed="1"   loop  autoplay></lottie-player>
    </div>
    <div class="w-full bg-white grid grid-cols-12 grid-rows-6 p-4">
        <div class="flex flex-col justify-around  col-start-2 col-end-12 row-start-2 row-end-6">
            <div class="text-center font-semibold text-purple-800">
                <img src="../assets/logo_marjane.svg" fill="currentColor" class="mx-auto h-20 w-2/6 text-purple-800"/>
<%--            </div><div class="text-center font-semibold text-purple-800">--%>
<%--                <h2>Log In</h2>--%>
<%--            </div>--%>
            <div>
                <div class="m-5 text-center rounded-sm">
                    <!-- <div class="col-span-2 bg-red-200 "></div> -->
                    <div class="border-l-4 border-x-purple-800 rounded-sm">
                        <input class="w-full bg-gray-50 outline-none py-3 px-2" type="email" placeholder="Email" ></input type="email" >
                    </div>
                </div>
                <div class="m-5 text-center rounded-sm">
                    <!-- <div class="col-span-2 bg-red-200 "></div> -->
                    <div class="border-l-4 border-x-purple-800 rounded-sm">
                        <input class="w-full bg-gray-50 outline-none py-3 px-2" type="email" placeholder="Password" ></input type="email" >
                    </div>
                </div>
            </div>
            <div class="text-center w-full px-5">
                <button class="w-full bg-purple-800 shadow-sm rounded-sm py-3 text-white font-semibold">SUBMIT</button>
            </div>

        </div>
    </div>
</div>

</body>
</html>

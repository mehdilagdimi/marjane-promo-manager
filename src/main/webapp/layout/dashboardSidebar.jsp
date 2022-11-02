<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 01-Nov-22
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<% String baseURL = application.getInitParameter("url"); %>
<%--<% String selectedTab = (String) Arrays.stream(request.getCookies()).filter( ck -> ck.getName() == "selectedTab").toArray()[0]; %>--%>
<div class="h-full w-40 sm:w-56  bg-gray-100 fixed left-0">
<%--    <header class="text-center select-none px-8 py-4 font-semibold">--%>
<%--        <lottie-player src="" class="text-center"--%>
<%--                       background="transparent" speed="1" loop autoplay></lottie-player>--%>
<%--    </header>--%>
    <ul class="list-none mt-14">
        <li class="px-8 py-4 hover:bg-[#0043BD] hover:pl-12 hover:text-white bg-[#0043BD] text-white pl-12  transition-all duration-75"><a href="#" class="block leading-10 "><i class="fa-solid fa-chart-pie mr-4"></i>Statistics</a></li>
        <li class="px-8 py-4 hover:bg-[#0043BD] hover:pl-12 hover:text-white transition-all duration-75"><a href="<%=baseURL%>PromotionServlet?get=all" class="block leading-10 "><i class="fa-solid fa-percent mr-4"></i>Promotion</a></li>
        <li class="px-8 py-4 hover:bg-[#0043BD] hover:pl-12 hover:text-white transition-all duration-75"><a href="#" class="block leading-10"><i class="fa-solid fa-layer-group mr-4"></i>Category</a></li>
        <li class="px-8 py-4 hover:bg-[#0043BD] hover:pl-12 hover:text-white transition-all duration-75"><a href="<%=baseURL%>SectionManagerServlet?get=all" class="block leading-10"><i class="fa-solid fa-people-roof mr-4"></i>Section Manager</a></li>
        <li class="px-8 py-4 hover:bg-[#0043BD] hover:pl-12 hover:text-white transition-all duration-75"><a href="#" class="block leading-10"><i class="fa-solid fa-shop mr-4"></i>Center</a></li>
    </ul>
</div>

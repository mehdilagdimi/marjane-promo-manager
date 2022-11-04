<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 01-Nov-22
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String baseURL = application.getInitParameter("url");
//    String role = (String)request.getSession().getAttribute("role");
    Map<String, Map<String, String>> sidebarTabs = (Map)request.getSession().getAttribute("sidebarTabs");
//    boolean isTabActive = request.get
//    String servletPath = ((String)request.getSession().getAttribute("servletpath")).toUpperCase();
//    System.out.println(" servlet path " + servletPath);
    boolean proceed = true;
%>

<%--<% String selectedTab = (String) Arrays.stream(request.getCookies()).filter( ck -> ck.getName() == "selectedTab").toArray()[0]; %>--%>
<div class="h-full w-16 sm:w-56  bg-gray-100 fixed left-0 z-40">
<%--    <header class="text-center select-none px-8 py-4 font-semibold">--%>
<%--        <lottie-player src="" class="text-center"--%>
<%--                       background="transparent" speed="1" loop autoplay></lottie-player>--%>
<%--    </header>--%>
        <ul class="list-none mt-14 block">
            <c:set var="proceed" scope="session" value="<%=proceed%>"/>
            <c:forEach var="key" items='${sidebarTabs.get(role).keySet()}'>
                    <li class="px-8 py-4 ${servletpath.contains(key.toUpperCase()) && proceed ? "bg-[#0043BD] text-white" : ""} ${proceed = servletpath.contains(key.toUpperCase()) ? false : true}  hover:bg-[#0043BD] hover:pl-12 hover:text-white focus:bg-[#0043BD] active:bg-[#0043BD] active:text-white  transition-all duration-75"><a href="<%=baseURL%>${sidebarTabs.get(role).get(key)[0]}" class="leading-10"><i class="${sidebarTabs.get(role).get(key)[1]} mr-4 inline-block"></i><h5 class="hidden sm:inline-block">${key}</h5></a></li>
<%--                    <li class="px-8 py-4 hover:bg-[#0043BD] hover:pl-12 hover:text-white transition-all duration-75"><a href="<%=baseURL%>PromotionServlet?get=all" class="  leading-10"><i class="fa-solid fa-percent mr-4 inline-block"></i><h5 class="hidden sm:inline-block ">Promotion</h5></a></li>--%>
<%--                    <li class="px-8 py-4 hover:bg-[#0043BD] hover:pl-12 hover:text-white transition-all duration-75"><a href="#" class=" leading-10"><i class="fa-solid fa-layer-group mr-4"></i><h5 class="hidden sm:inline-block ">Category</h5></a></li>--%>
<%--                    <li class="px-8 py-4 hover:bg-[#0043BD] hover:pl-12 hover:text-white transition-all duration-75"><a href="<%=baseURL%>ManagerServlet?get=all" class=" block leading-10"><i class="fa-solid fa-people-roof mr-4"></i><h5 class="hidden sm:inline-block ">Manager</h5></a></li>--%>
<%--                    <li class="px-8 py-4 hover:bg-[#0043BD] hover:pl-12 hover:text-white transition-all duration-75"><a href="<%=baseURL%>SectionManagerServlet?get=all" class=" block leading-10"><i class="fa-solid fa-people-roof mr-4"></i><h5 class="hidden sm:inline-block ">Section Manager</h5></a></li>--%>
<%--                    <li class="px-8 py-4 hover:bg-[#0043BD] hover:pl-12 hover:text-white transition-all duration-75"><a href="#" class="leading-10"><i class="fa-solid fa-shop mr-4"></i><h5 class="hidden sm:inline-block ">Center</h5></a></li>--%>

            </c:forEach>
        </ul>
</div>

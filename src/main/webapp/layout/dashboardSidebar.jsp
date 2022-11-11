<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 01-Nov-22
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    String baseURL = application.getInitParameter("url");
    Map<String, Map<String, String>> sidebarTabs = (Map)request.getSession().getAttribute("sidebarTabs");
    boolean proceed = true;
%>

<div class="h-full w-16 lg:w-56  bg-gray-100 fixed left-0 z-40">
        <ul class="list-none mt-14 block">
            <c:set var="proceed" scope="session" value="<%=proceed%>"/>
            <c:forEach var="key" items='${sidebarTabs.get(role).keySet()}'>
                    <li class="px-8 py-4 ${servletpath.contains(key.toUpperCase()) && proceed ? "bg-[#0043BD] text-white" : ""} ${proceed = servletpath.contains(key.toUpperCase()) ? false : true}  hover:bg-[#0043BD] hover:pl-12 hover:text-white focus:bg-[#0043BD] active:bg-[#0043BD] active:text-white  transition-all duration-75"><a href="<%=baseURL%>${sidebarTabs.get(role).get(key)[0]}" class="leading-10"><i class="${sidebarTabs.get(role).get(key)[1]} mr-4 inline-block"></i><h5 class="hidden lg:inline-block">${key}</h5></a></li>
            </c:forEach>
        </ul>
</div>

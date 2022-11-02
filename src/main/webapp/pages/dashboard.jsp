<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 01-Nov-22
  Time: 11:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="../layout/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.marjanefranchise.marjane_franchise_promotion_manager.entity.Promotion" %>
<link rel="stylesheet" href="<%=application.getInitParameter("url")%>styles/base.css">
<div class="flex flex-row h-full w-full absolute top-20">
    <%@ include file="../layout/dashboardSidebar.jsp" %>
    <div class="ml-40 sm:ml-56 w-full bg-white flex flex-col p-8 overflow-x-scroll">
        <c:choose>

            <c:when test="${records != null}">
                <c:if test='${recordstype.equals("promotion")}'>
                    <div class="w-full bg-gray-50 p-4 grid grid-cols-5 text-center text-md font-semibold mx-3 my-2 min-w-full shadow-sm rounded-sm min-w-full overflow-x-scroll">
                        <div class="block">ID</div>
                        <div class="block">Status</div>
                        <div class="block">Valid Until</div>
                        <div class="block">Percentage</div>
                        <div class="block">Market</div>
                    </div>
                    <c:forEach var="promotion" items="${records}">
                        <div class="card cursor-pointer w-full bg-blue-50 flex flex-col p-0 mx-3 my-1 shadow-sm rounded-sm min-w-full overflow-x-scroll">
                            <div class="w-full bg-gray-50 p-4 grid grid-cols-5 text-center text-md font-light">
                                <div class="block">
                                        ${promotion.getId()}
                                </div>
                                <div class="block">
                                        ${promotion.getStatus()}
                                </div>
                                <div class="block">
                                        ${promotion.getValidUntil()}
                                </div>
                                <div class="block">
                                        ${promotion.getPercentage()}
                                </div>
                                <div class="block">
                                        ${promotion.getCenter().getCity()}
                                </div>
                            </div>
                            <div class="card-details w-full px-4 py-8 hidden grid grid-cols-2 border-l-8 border-white text-center text-md font-light">
                                <div class="col-span-1 w-full">
                                        <header class="text-sm">
                                            SECTION MANAGER COMMENT :
                                        </header>
                                        <p class="font-semibold">
                                            ${promotion.getComment()}
                                        </p>
                                </div>
                                <div class="col-span-1 w-full">
                                    <div class="dropdown relative inline-block">
                                        <button class="bg-gray-150 border border-gray-500 shadow-sm rounded-sm">Sub-Categories</button>
                                        <div class="dropdown-content hidden absolute">
                                            <c:forEach var="category" items="${promotion.getSubCategoryList()}">
                                                <a href="#" class="block no-underline bg-white border border-gray-50">${category.getName()}</a>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>

                <c:if test='${recordstype.equals("sectionmanager")}'>
                    <div class="w-full bg-gray-50 p-4 grid grid-cols-5 text-center text-md font-semibold mx-3 my-2 shadow-sm rounded-sm">
                        <div class="block">ID</div>
                        <div class="block">Name</div>
                        <div class="block">Email</div>
                        <div class="block">Category</div>
                        <div class="block">Market</div>
                    </div>
                    <c:forEach var="sectionmanager" items="${records}">
                        <div class="card cursor-pointer w-full bg-blue-50 flex flex-col p-0 mx-3 my-1 shadow-sm rounded-sm">
                            <div class="w-full bg-gray-50 p-4 grid grid-cols-5 text-center text-md font-light">
                                <div class="block">
                                        ${sectionmanager.getId()}
                                </div>
                                <div class="block">
                                        ${sectionmanager.getFullname()}
                                </div>
                                <div class="block">
                                        ${sectionmanager.getEmail()}
                                </div>
                                <div class="block">
                                        ${sectionmanager.getCategory().getName()}
                                </div>
                                <div class="block">
                                        ${sectionmanager.getCenter().getCity()}
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>

            </c:when>
        </c:choose>
    </div>
</div>
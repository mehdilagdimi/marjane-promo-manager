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

<%--<% String role = (String)request.getSession().getAttribute("role"); %>--%>
<% String activePage = (String)request.getSession().getAttribute("activePage"); %>

<div class="flex flex-row h-full w-full absolute top-20">
    <%@ include file="../layout/dashboardSidebar.jsp" %>
    <div class="ml-16 sm:ml-56 mr-8 sm:mr-14 relative w-full">
        <div class='${recordstype.equals("manager") && role.equals("superadmin")? "flex" : "hidden"} justify-end m-6'>
            <button onclick="toggleDisplayForm()" class="bg-[#0043BD] py-3 px-12 shadow-sm rounded-sm text-white font-semibold hover:bg-yellow-500 hover:text-[#0043BD]">New</button>
        </div>
        <%@ include file="../layout/addManager.jsp" %>
        <div class="m-4 overflow-x-auto no-scroll absolute left-4 right-0" id="recordsDivId">
            <div class="bg-white flex flex-col p-4 min-w-[1400px]">
                    <c:choose>
                        <c:when test="${records != null}">
                            <c:if test='${recordstype.equals("promotion")}'>
                                <div class="bg-gray-50 p-4 grid grid-cols-5 text-center text-md font-semibold mx-3 my-2 shadow-sm rounded-sm ">
                                    <div class="block">ID</div>
                                    <div class="block">Status</div>
                                    <div class="block">Valid Until</div>
                                    <div class="block">Percentage</div>
                                    <div class="block">Market</div>
                                </div>
                                <c:forEach var="promotion" items="${records}">
                                    <div class="card cursor-pointer bg-blue-50 flex flex-col p-0 mx-3 my-1 shadow-sm rounded-sm ">
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

                            <c:if test='${recordstype.equals("manager")}'>
                                <div class="w-full bg-gray-50 p-4 grid grid-cols-5 text-center text-md font-semibold mx-3 my-2 shadow-sm rounded-sm">
                                    <div class="block">ID</div>
                                    <div class="block">Name</div>
                                    <div class="block">Email</div>
                                    <div class="block">Category</div>
                                    <div class="block">Market</div>
                                </div>
                                <c:forEach var="manager" items="${records}">
                                    <div class="card cursor-pointer w-full bg-blue-50 flex flex-col p-0 mx-3 my-1 shadow-sm rounded-sm">
                                        <div class="w-full bg-gray-50 p-4 grid grid-cols-4 text-center text-md font-light">
                                            <div class="block">
                                                    ${manager.getId()}
                                            </div>
                                            <div class="block">
                                                    ${manager.getFullname()}
                                            </div>
                                            <div class="block">
                                                    ${manager.getEmail()}
                                            </div>
                                            <div class="block">
                                                    ${manager.getCenter().getCity()}
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>

                        </c:when>
                    </c:choose>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
    function toggleDisplayForm() {
        let addForm = document.getElementById("addSectionManagerForm");
        let records = document.getElementById("recordsDivId");
        if (addForm.style.display === "block") {
            records.style.display = "block";
            addForm.style.display = "none";
        } else {
            records.style.display = "none";
            addForm.style.display = "block";
        }
    }
</script>
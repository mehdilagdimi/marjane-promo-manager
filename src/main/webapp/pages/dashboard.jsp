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
<%--<script defer>--%>
<%--    $(document).ready(function () {--%>
<%--        $('#tableDashboard').DataTable();--%>
<%--    });--%>
<%--</script>--%>
<%--<% String role = (String)request.getSession().getAttribute("role"); %>--%>
<%
    String activePage = (String) request.getSession().getAttribute("activePage");
    Promotion selectedPromotion = null;
    String auth = (String) request.getSession().getAttribute("unauthorizedAccess");
    System.out.println(" printing auht state " + auth);
%>

<div class="flex flex-row  w-full absolute top-20">
    <%@ include file="../layout/dashboardSidebar.jsp" %>
    <div class="ml-16 lg:ml-56 mr-8 sm:mr-14 relative w-full">
        <div class='${recordstype.equals("manager") && role.equals("superadmin")? "flex" : "hidden"} justify-end mx-6 my-2'>
            <button onclick="toggleDisplayForm()"
                    class="bg-[#0043BD] py-3 px-12 shadow-sm rounded-sm text-white font-semibold hover:bg-yellow-500 hover:text-[#0043BD]">
                New
            </button>
        </div>
        <%@ include file="../layout/addManager.jsp" %>

        <c:if test='${recordstype.equals("promotion")}'>
            <div class="w-full flex flex-col flex-wrap w-full">
                <div class="relative w-full bottom-0 top-[500px] z-[99]">
                    <c:if test='${role.equals("manager") || role.equals("superadmin")}'>
                        <%@ include file="../layout/promotionDetails.jsp" %>
                    </c:if>
                    <c:if test='${role.equals("manager")}'>
                        <%@ include file="../layout/addPromotion.jsp" %>
                    </c:if>
                </div>
                <div class="relative bottom-0 top-[500px] z-50">
                    <c:if test='${role.equals("sectionmanager")}'>
                        <%@ include file="../layout/editStatusPromotionDetails.jsp" %>
                    </c:if>
                </div>

            </div>
            <div class="flex justify-end mx-6 my-2 py-3">
                <c:if test='${role.equals("manager")}'>
                    <a href="#addPromotionForm">
                        <button onclick="toggleDisplayAddPromotionForm()"
                                class="bg-[#0043BD] py-3 px-12 shadow-sm rounded-sm text-white font-semibold hover:bg-yellow-500 hover:text-[#0043BD]">
                            New
                        </button>
                    </a>
                </c:if>
            </div>
        </c:if>
        <c:choose>
            <c:when test='${recordstype.equals("statistics")}'>
                <%@ include file="../components/statistics.jsp" %>
            </c:when>
            <c:when test="${unauthorizedAccess != null}">
                <div class="mx-auto w-full bg-red font-bold text-md text-center text-red-500">
                    <h2>Unauthorized acces to promotion out of : 8h-12h</h2>
                </div>
            </c:when>
            <c:when test="${records != null && unauthorizedAccess == null}">
                <div class="z-50 mx-4 my-2 overflow-x-auto no-scroll absolute left-4 right-0 editPromotionForm"
                     id="recordsDivId">
                    <div class="overflow-y-auto bg-white flex flex-col min-w-[1400px] h-[450px]">
                        <c:if test='${recordstype.equals("promotion")}'>
                            <div class="sticky top-0 bg-gray-200  p-6 grid grid-cols-5 text-center text-md font-semibold mx-3 my-2 shadow-sm rounded-sm">
                                <div class="block">ID</div>
                                <div class="block">Status</div>
                                <div class="block">Valid Until</div>
                                <div class="block">Percentage</div>
                                <div class="block">Market</div>
                            </div>
                            <c:forEach var="promotion" items="${records}">
                                <a href="#editPromotionForm"
                                   onclick="window.location.replace('<%=baseURL%>PromotionServlet?selected=${promotion.getId()}', '_self')">
                                    <div class="card cursor-pointer bg-blue-50 flex flex-col p-0 mx-3 my-1 shadow-sm rounded-sm">
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
                                                    ${promotion.getCenter().getCity()} ${promotion.getCenter().getId()}

                                            </div>
                                        </div>
                                        <div class="card-details w-full px-4 py-8 hidden grid grid-cols-2 border-l-8 border-white text-center text-md font-light">
                                            <div class="col-span-1 w-full">
                                                <header class="text-sm bg-gray-150 border border-gray-200 shadow-sm w-[200px] p-2 rounded-md">
                                                    SECTION MANAGER COMMENT :
                                                </header>
                                                <p class="font-semibold">
                                                        ${promotion.getComment()}
                                                </p>
                                            </div>
                                            <div class="col-span-1 w-full">
                                                <div class="dropdown inline-block">
                                                    <button class="bg-gray-150 border border-gray-200 shadow-sm w-[200px] p-2 rounded-md">
                                                        Sub-Categories
                                                    </button>
                                                    <div class="dropdown-content hidden">
                                                        <ul class="list-none block bg-white border rounded-md w-[200px] max-h-fit overflow-y-scroll">
                                                            <c:forEach var="category"
                                                                       items="${promotion.getSubCategoryList()}">
                                                                <li class="border text-center hover:bg-gray-50">
                                                                    <a href="#"
                                                                       class="block no-underline bg-white">${category.getName()}</a>
                                                                </li>
                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </a>
                            </c:forEach>

                        </c:if>

                        <c:if test='${recordstype.equals("sectionmanager")}'>
                            <div class="sticky top-0 bg-gray-200  p-6 grid grid-cols-5 text-center text-md font-semibold mx-3 my-2 shadow-sm rounded-sm">
                                <div class="block">ID</div>
                                <div class="block">Name</div>
                                <div class="block">Email</div>
                                <div class="block">Category</div>
                                <div class="block">Market</div>
                            </div>
                            <c:forEach var="sectionmanager" items="${records}">
                                <div class="card cursor-pointer bg-blue-50 flex flex-col p-0 mx-3 my-1 shadow-sm rounded-sm">
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
                            <div class="sticky top-0 bg-gray-200  p-6 grid grid-cols-5 text-center text-md font-semibold mx-3 my-2 shadow-sm rounded-sm">
                                <div class="block">ID</div>
                                <div class="block">Name</div>
                                <div class="block">Email</div>
                                <div class="block">Market</div>
                            </div>
                            <c:forEach var="manager" items="${records}">
                                <div class="card cursor-pointer bg-blue-50 flex flex-col p-0 mx-3 my-1 shadow-sm rounded-sm">
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

                    </div>

                </div>
            </c:when>
        </c:choose>
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

    function toggleDisplayAddPromotionForm() {
        let addForm = document.getElementById("addPromotionForm");
        if (addForm.style.display === "block") {
            addForm.style.display = "none";
        } else {
            addForm.style.display = "block";
        }
    }

    function toggleDisplayEditPromotionForm() {
        let editForm = document.getElementById("editPromotionForm");
        if (editForm.style.display === "block") {
            editForm.style.display = "none";
        } else {
            editForm.style.display = "block";
        }
    }
</script>
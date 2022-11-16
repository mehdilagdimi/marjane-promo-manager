<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 09-Nov-22
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="${selectedPromotion != null ? 'flex' : 'hidden'} w-full bottom-0 top-[200px] my-2 absolute flex-col justify-center items-start" id="editPromotionForm">
    <div class="mx-auto w-full flex justify-end">
        <div class="bg-[#0043BD] cursor-pointer mb-2 py-3 px-12 mx-2 shadow-sm rounded-sm text-white font-semibold hover:bg-yellow-500 hover:text-[#0043BD]"
             onclick="toggleDisplayeditPromotionForm()">
            Hide
        </div>
    </div>
    <form action="<%=application.getInitParameter("url")%>PromotionServlet?post=status,comment" method="post" class="w-full mx-10 flex flex-row w-full items-center justify-around shadow-sm">
        <div class="flex flex-col w-full items-center shadow-sm">
            <div class="w-full flex justify-start flex-wrap mx-3 mb-1">
                <div class="inline-block w-full px-3">
                    <div class="inline-block w-[250px]"><h4>Promotion ID :</h4></div>
                    <div class="p-3 bg-gray-50 border inline-block"> ${selectedPromotion.getId()}</div>
                    <input type="hidden" name="promotionId" value="${selectedPromotion.getId()}"  required>
                </div>
            </div>
            <div class="w-full flex justify-start flex-wrap mx-3 mb-1">
                <div class="inline-block w-full px-3">
                    <div class="inline-block w-[250px]"><h4>On Market :</h4></div>
                    <div class="inline-block p-3 bg-gray-50 border"> ${selectedPromotion.getCenter().getCity()} ${selectedPromotion.getCenter().getId()}</div>
                </div>
            </div>

            <div class="w-full flex justify-start flex-wrap mx-3 mb-1">
                <div class="inline-block w-full px-3">
                    <div class="inline-block w-[250px]"><h4>For sub-categories :</h4></div>
                    <div class="dropdown inline-block ">
                        <div class="bg-gray-200 cursor-pointer text-center border border-gray-200 w-[200px] p-2 rounded-sm">Sub-Categories
                        </div>
                        <div class="dropdown-content hidden absolute">
                            <ul class="list-none block bg-white border rounded-md w-[200px] max-h-fit overflow-y-scroll">
                                <c:forEach var="category" items="${selectedPromotion.getSubCategoryList()}">
                                    <li class="border text-center hover:bg-gray-50">
                                        <a href="#" class="block no-underline bg-white">${category.getName()}</a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="w-full flex justify-start flex-wrap mx-3 mb-1">
                <div class="inline-block w-full px-3">
                    <div class="inline-block w-[250px]"><h4>Valid Until :</h4></div>
                    <div class="inline-block p-3 bg-gray-50 border">${selectedPromotion.getValidUntil()}</div>

                </div>
            </div>
<%--            <div class="w-full flex justify-start flex-wrap mx-3 mb-1">--%>
<%--                <div class="inline-block w-full px-3">--%>
<%--                    <div class="inline-block w-[250px]"><h4>Comment :</h4></div>--%>
<%--                    <div class="inline-block p-3 bg-gray-50 border">${selectedPromotion.getComment() != null ? selectedPromotion.getComment() : "'No comment'"}</div>--%>

<%--                </div>--%>
<%--            </div>--%>
            <div class="w-full flex justify-start flex-wrap mx-3 mb-1">
                <div class="block px-3"><h4>Status :</h4></div>
                <div class="w-full flex justify-around">
                    <c:choose>
                        <c:when test='${selectedPromotion.getStatus().equals("en cours")}'>
                            <a class="w-full block m-2" href="#acceptBtn"><h2 onclick="selectAcceptBtn()" id="acceptBtn" class="px-3 py-4 text-center font-semibold  text-md bg-gray-50 border shadow-sm rounded-md">Accept</h2></a>
                            <a class="w-full block m-2" href="#refuseBtn" ><h2 onclick="selectRefuseBtn()" id="refuseBtn" class="px-3 py-4 text-center font-semibold text-md bg-gray-50 border shadow-sm rounded-md">Refuse</h2></a>
                            <input type="hidden" name="status" value="" id="newStatusId" required>
                        </c:when>
                        <c:when test='${selectedPromotion.getStatus().equals("accepter")}'>
                            <a class="w-full block"><h2 class="px-3 py-4 m-2 text-center font-semibold text-gray-300 text-md bg-gray-50 border shadow-sm rounded-md">Accepted</h2></a>
                        </c:when>
                        <c:when test='${selectedPromotion.getStatus().equals("refuse")}'>
                            <a class="w-full block"><h2 class="px-3 py-4 m-2 text-center font-semibold text-gray-300 text-md bg-gray-50 border shadow-sm rounded-md">Refused</h2></a>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
        <div class="relative flex flex-col my-auto h-full w-full mx-4">
            <div class="w-full h-full shadow-sm">
                <label class="font-semi-bold m-2">Add Comment :</label>
                <textarea name="comment" class="min-h-[150px] min-w-[100px] mt-4 w-full py-3 px-4 border-2 border-gray-100 bg-gray-50 outline-none" placeholder="..." ${selectedPromotion.getComment() ? 'disabled' : ''}>${selectedPromotion.getComment()}</textarea>
            </div>
            <div class="absolute bottom-0 my-2 w-full flex justify-end">
                <button type="submit" id="submitBtn" class="hidden bg-[#0043BD] cursor-pointer mb-2 py-3 px-12 mx-2 shadow-sm rounded-sm text-white font-semibold hover:bg-yellow-500 hover:text-[#0043BD]">
                    Submit
                </button>
            </div>
        </div>
    </form>
</div>

<script>
    function toggleDisplayeditPromotionForm() {
        let editForm = document.getElementById("editPromotionForm");
        editForm.style.display = "none";
    }

    function selectAcceptBtn() {
        let acceptBt = document.getElementById("acceptBtn");
        document.getElementById("newStatusId").value = "accepter";
        acceptBt.classList.add("bg-green-500");
        acceptBt.classList.add("text-white");
        let refuseBtn = document.getElementById("refuseBtn");
        refuseBtn.classList.remove("bg-red-500");
        refuseBtn.classList.remove("text-white");

        displaySubmitBtn();
    }

    function selectRefuseBtn(){
        let refuseBtn =  document.getElementById("refuseBtn");
        document.getElementById("newStatusId").value = "refuse";
        refuseBtn.classList.add("bg-red-500");
        refuseBtn.classList.add("text-white");
        let acceptBt = document.getElementById("acceptBtn");
        acceptBt.classList.remove("bg-green-500");
        acceptBt.classList.remove("text-white");

        displaySubmitBtn();
    }
    function displaySubmitBtn(){
        let submitBtn =  document.getElementById("submitBtn");
        submitBtn.style.display = "block";
    }

</script>
<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 09-Nov-22
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="${selectedPromotion != null ? 'flex' : 'hidden'} w-full bottom-0 top-60 absolute flex-col justify-center items-start" id="editPromotionForm">
    <form action="" method="post" class="w-full mx-10 flex flex-col w-[700px] items-center shadow-sm">
        <div class="mx-10 w-full flex justify-end">
            <div class="bg-[#0043BD] cursor-pointer my-3 py-3 px-12 shadow-sm rounded-sm text-white font-semibold hover:bg-yellow-500 hover:text-[#0043BD]"
                onclick="toggleDisplayeditPromotionForm()">
                Hide
            </div>
        </div>
        <div class="w-full flex justify-start flex-wrap mx-3 mb-1">
            <div class="inline-block w-full px-3">
                <div class="inline-block w-[250px]"><h4>Promotion ID :</h4></div>
                <div class="p-3 bg-gray-50 border inline-block"> ${selectedPromotion.getId()}</div>
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
        <div class="w-full flex justify-start flex-wrap mx-3 mb-1">
            <div class="inline-block w-full px-3">
                <div class="inline-block w-[250px]"><h4>Comment :</h4></div>
                <div class="inline-block p-3 bg-gray-50 border">${selectedPromotion.getComment() != null ? selectedPromotion.getComment() : "'No comment'"}</div>

            </div>
        </div>
        <div class="w-full flex justify-start flex-wrap mx-3 mb-1">
                <div class="block px-3"><h4>Status :</h4></div>
                <div class="w-full block px-3 py-4 m-2 text-center ${selectedPromotion.getStatus().equals("accepter") ? "text-green-500 " : selectedPromotion.getStatus().equals("en cours") ? "text-yellow-500" : "text-red-500"} font-semibold text-lg bg-gray-50 border shadow-sm rounded-md">${selectedPromotion.getStatus()}</div>
        </div>

    </form>
</div>

<script>
    function toggleDisplayeditPromotionForm() {
        let editForm = document.getElementById("editPromotionForm");
        editForm.style.display = "none";
    }
</script>
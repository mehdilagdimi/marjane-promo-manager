<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 09-Nov-22
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="${selectedPromotion != null ? 'flex' : 'hidden'} w-fuhil bottom-0 top-0 absolute flex-col justify-center items-start" id="editPromotionForm">
    <div class="w-[500px] flex justify-end">
        <button class="bg-blue-500">Hide</button>
    </div>
    <form action="" method="post" class="w-full flex flex-col w-[500px] border">
        <div>
            <div>${selectedPromotion.getId()}</div>
            <div>${selectedPromotion.getCenter()} ${selectedPromotion.getCenter().getId()}</div>
        </div>
        <div>
            <div>${selectedPromotion.getComment()}</div>
        </div>
        <div>
            <div class="dropdown inline-block">
                <button class="bg-gray-150 border border-gray-200 shadow-sm w-[200px] p-2 rounded-md">Sub-Categories
                </button>
                <div class="dropdown-content hidden">
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
        <div>
            <button class="bg-green-400">Accept</button>
            <button class="bg-red-500">Declinet</button>
        </div>
    </form>
</div>
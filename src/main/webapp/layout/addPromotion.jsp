<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.time.Instant" %>
<%@ page import="com.marjanefranchise.marjane_franchise_promotion_manager.util.TimeHelper.TimeUtil" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 03-Nov-22
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String minDate = TimeUtil.timestampToHtmlDateTimeLocal(Timestamp.from(Instant.now()).toString());
    System.out.println(" min date " + minDate);
%>
<div class="hidden w-full bottom-0 top-[430px] absolute flex justify-center items-center"  id="addPromotionForm">
  <div class="p-4">
    <form action="<%=application.getInitParameter("url")%>PromotionServlet?post=promotion" method="post" class="w-full flex flex-col items-end">
      <div class="flex justify-start flex-wrap mx-3 mb-6">
        <div class=" w-full w-[150px] md:w-[500px] px-3 mb-6 md:mb-0">
          <label class="w-full block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-percentage">
            Percentage
          </label>
          <input name="percentage" class="appearance-none block w-full bg-gray-50 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" id="grid-percentage" type="number" step="any" placeholder="Percentage" required>
          <p class="text-red-500 text-xs italic">Please fill out this field.</p>
        </div>
      </div>
      <div class="flex justify-start flex-wrap mx-3 mb-6">
      <div class=" w-full md:w-[500px] px-3 mb-6 md:mb-0">
          <label class="w-full block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-validUntil">
           Valid Until
          </label>
          <input name="validUntil" class="appearance-none block w-full bg-gray-50 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" id="grid-validUntil" min="<%=minDate%>" type="datetime-local"  step="any" placeholder="Valid Until" required>
          <p class="text-red-500 text-xs italic">Please fill out this field.</p>
        </div>
      </div>
        <div class="w-full flex justify-end flex-wrap mx-3 mb-6">
            <div class="w-full md:w-[500px] px-3 mb-6 md:mb-0">
                <label class="block text-left" style="max-width: 300px;">
                    <span class="text-gray-700">Apply On :</span>
                    <select name="selectSubCategories" class="form-multiselect block w-full mt-1" multiple>
                        <c:if test="${subcategoriesoptions != null}"  >
                            <c:forEach var="subcategory" items="${subcategoriesoptions}">
                                <option value="${subcategory.getId()}">${subcategory.getName()}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </label>
            </div>
        </div>
      <div class="flex justify-end m-6">
        <button type="submit" class="bg-[#0043BD] py-3 px-12 shadow-sm rounded-sm text-white font-semibold hover:bg-yellow-500 hover:text-[#0043BD]">NEW PROMOTION</button>
      </div>
    </form>
  </div>

</div>


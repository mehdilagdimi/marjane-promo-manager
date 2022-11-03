<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 03-Nov-22
  Time: 1:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="hidden w-full flex justify-center items-center"  id="addSectionManagerForm">
  <div class="p-4">
    <form action="<%=application.getInitParameter("url")%>ManagerServlet" method="post" class="w-full flex flex-col items-center">
      <div class="flex justify-start flex-wrap mx-3 mb-6">
        <div class=" w-full md:w-[500px] px-3 mb-6 md:mb-0">
          <label class="w-full block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-fullname">
            Full Name
          </label>
          <input name="fullname" class="appearance-none block w-full bg-gray-50 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" id="grid-fullname" type="text" placeholder="Full Name">
          <p class="text-red-500 text-xs italic">Please fill out this field.</p>
        </div>
      </div>
      <div class="flex justify-start flex-wrap mx-3 mb-6">
      <div class=" w-full md:w-[500px] px-3 mb-6 md:mb-0">
          <label class="w-full block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-email">
           Email
          </label>
          <input name="email" class="appearance-none block w-full bg-gray-50 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" id="grid-email" type="email" placeholder="Email">
          <p class="text-red-500 text-xs italic">Please fill out this field.</p>
        </div>
      </div>
      <div class="flex justify-start flex-wrap mx-3 mb-2">
        <div class="w-full md:w-[500px] px-3 mb-6 md:mb-0">
          <label class="w-full block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="grid-city">
            Market
          </label>
          <input name="center_id" class="appearance-none block w-full bg-gray-50 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="grid-city" type="text" placeholder="City">
          <input name="center_idfornext" type="hidden">
          <p class="text-red-500 text-xs italic">Please fill out this field.</p>
        </div>
      </div>
      <div class="flex justify-end m-6">
        <button type="submit" class="bg-[#0043BD] py-3 px-12 shadow-sm rounded-sm text-white font-semibold hover:bg-yellow-500 hover:text-[#0043BD]">Submit</button>
      </div>
    </form>
  </div>

</div>


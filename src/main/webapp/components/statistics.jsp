<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 14-Nov-22
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="px-4 py-16 mx-auto sm:max-w-xl md:max-w-full lg:max-w-screen-xl md:px-24 lg:px-8 lg:py-20">
    <div class="grid grid-cols-2 row-gap-8 md:grid-cols-4">
        <div class="text-center md:border-r">
            <h6 class="text-4xl font-bold lg:text-5xl xl:text-6xl">${promotionCount}</h6>
            <p class="text-sm font-medium tracking-widest text-gray-800 uppercase lg:text-base">
                Promotions
            </p>
        </div>
        <div class="text-center md:border-r">
            <h6 class="text-4xl font-bold lg:text-5xl xl:text-6xl">${categoryCount}</h6>
            <p class="text-sm font-medium tracking-widest text-gray-800 uppercase lg:text-base">
                Categories/Sub-categories
            </p>
        </div>
        <div class="text-center md:border-r">
            <h6 class="text-4xl font-bold lg:text-5xl xl:text-6xl">${managerCount}</h6>
            <p class="text-sm font-medium tracking-widest text-gray-800 uppercase lg:text-base">
                Managers
            </p>
        </div>
        <div class="text-center">
            <h6 class="text-4xl font-bold lg:text-5xl xl:text-6xl">${sectionManagerCount}</h6>
            <p class="text-sm font-medium tracking-widest text-gray-800 uppercase lg:text-base">
                Sections Manager
            </p>
        </div>
    </div>
</div>
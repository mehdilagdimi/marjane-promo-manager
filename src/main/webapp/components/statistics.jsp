<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 14-Nov-22
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Required chart.js -->
<% System.out.println(" stats" + request.getSession().getAttribute("promotionStatusStatistics")); %>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<div class="ml-8 px-4 py-16 mx-auto sm:max-w-xl md:max-w-full lg:max-w-screen-xl md:px-24 md:mx-auto no-scroll lg:px-8 lg:py-20 overflow-x-scroll">
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
    <div class="grid grid-cols-1 row-gap-8 ">
        <div class="shadow-lg rounded-lg overflow-hidden h-[500px] w-[460px] my-[100px]  my-16 mx-auto col-auto">
                <div class="py-3 px-5 bg-gray-50 text-center">Promotion status chart</div>
                <canvas class="p-10" id="chartDoughnut"></canvas>
            </div>
    </div>
    <!-- Chart doughnut -->
    <script>
        temp="${promotionStatusStatistics}";
        // var dataArr = new Array();
        dataArr = temp.split(',');
        console.log(" testing arr " + dataArr);
        const dataDoughnut = {
            labels: ["Refused", "Accepted", "Waiting"],
            datasets: [
                {
                    label: "Number",
                    // data: [300, 50, 100],
                    <%--data: <%= request.getSession().getAttribute("promotionStatusStatistics") %>,--%>
                    data: dataArr,
                    backgroundColor: [
                        "rgb(255, 0, 0)",
                        "rgb(0, 255, 0)",
                        "rgb(255, 165, 0)",
                    ],
                    hoverOffset: 4,
                },
            ],
        };

        const configDoughnut = {
            type: "doughnut",
            data: dataDoughnut,
            options: {},
        };

        var chartBar = new Chart(
            document.getElementById("chartDoughnut"),
            configDoughnut
        );
    </script>
</div>
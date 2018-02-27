$(function () {
    //导出必须配置的两个量
    dataTableName = "#siteListTable";
    docName = "站点信息";
    mainObject = "site";


    initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "站点名称"}
    ];

    initBootGrid(dataTableName);
    $("#searchBtn").trigger("click");


});

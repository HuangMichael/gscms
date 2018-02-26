/**
 * Created by huangbin on 2016/11/2.

 */


$(function () {


    //导出必须配置的两个量
    dataTableName = "#columnsListTable";
    docName = "栏目信息";
    mainObject = "columns";


    initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "栏目名称"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

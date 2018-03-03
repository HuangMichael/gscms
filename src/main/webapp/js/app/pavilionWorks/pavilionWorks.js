/**
 * Created by huangbin on 2016/11/2.

 */


$(function () {


    //导出必须配置的两个量
    dataTableName = "#pavilionWorksListTable";
    docName = "展馆作品";
    mainObject = "pavilionWorks";

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "作品名称"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

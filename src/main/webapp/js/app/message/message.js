/**
 * Created by huangbin on 2016/11/2.

 */


$(function () {


    //导出必须配置的两个量
    dataTableName = "#messageListTable";
    docName = "留言信息";
    mainObject = "message";


    initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "留言内容"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

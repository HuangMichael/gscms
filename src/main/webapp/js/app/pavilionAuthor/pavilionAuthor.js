/**
 * Created by huangbin on 2016/11/2.

 */


$(function () {


    //导出必须配置的两个量
    dataTableName = "#memberListTable";
    docName = "会员信息";
    mainObject = "member";


    initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "会员名称"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

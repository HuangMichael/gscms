/**
 * Created by huangbin on 2016/11/2.

 */


$(function () {


    //导出必须配置的两个量
    dataTableName = "#pavilionAuthorListTable";
    docName = "会员信息";
    mainObject = "pavilionAuthor";



    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "会员名称"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

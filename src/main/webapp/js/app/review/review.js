/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {
    dataTableName = "#reviewListTable";
    docName = "³õÉóÁÐ±í";
    mainObject = "review";
    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "¹Ø¼ü×Ö"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {
    dataTableName = "#reviewListTable";
    docName = "�����б�";
    mainObject = "review";
    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "�ؼ���"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

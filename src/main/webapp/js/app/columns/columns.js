/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {


//导出必须配置的两个量
    dataTableName = "#columnsListTable";
    docName = "��Ŀ����";
    mainObject = "columns";


    initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "��Ŀ����"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

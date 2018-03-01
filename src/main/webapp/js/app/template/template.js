/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {


//导出必须配置的两个量
    dataTableName = "#templateListTable";
    docName = "模板管理";
    mainObject = "template";


    initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "关键字"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

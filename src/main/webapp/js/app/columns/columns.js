/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {


//瀵煎嚭蹇呴』閰嶇疆鐨勪袱涓噺
    dataTableName = "#columnsListTable";
    docName = "栏目管理";
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

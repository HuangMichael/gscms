/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {


//导出必须配置的两个量
    dataTableName = "#memberListTable";
    docName = "��Ա����";
    mainObject = "member";


    // initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "�ؼ���?"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {


//瀵煎嚭蹇呴』閰嶇疆鐨勪袱涓噺
    dataTableName = "#memberListTable";
    docName = "会员管理";
    mainObject = "member";


    // initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "关键字?"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

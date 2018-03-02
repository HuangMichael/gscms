/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {


//瀵煎嚭蹇呴』閰嶇疆鐨勪袱涓噺
    dataTableName = "#memberWorksListTable";
    docName = "会员作品";
    mainObject = "memberWorks";


    initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "鍏抽敭瀛?"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

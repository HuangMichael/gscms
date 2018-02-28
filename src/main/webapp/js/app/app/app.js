/**
 * Created by huangbin on 2016/11/2.

 */


$(function () {


    //导出必须配置的两个量
    dataTableName = "#appListTable";
    docName = "应用信息";
    mainObject = "app";


    initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "应用名称"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});


/**
 *
 */
function genApp() {
    var selectedId = $(dataTableName).bootgrid("getSelectedRows");
    var url = "/app/autoCode";
    var data = {
        appId: selectedId[0]
    };
    $.post(url, data, function (data) {
        if (data.result) {
            showMessageBox("info", data["resultDesc"]);
        } else {
            showMessageBox("danger", data["resultDesc"]);

        }
    })

}

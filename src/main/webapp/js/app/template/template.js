/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {


//�����������õ�������
    dataTableName = "#templateListTable";
    docName = "ģ�����";
    mainObject = "template";


    initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "�ؼ���"}
    ];

    initBootGrid(dataTableName);

    $("#searchBtn").trigger("click");


});

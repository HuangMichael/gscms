var validationConfig = {
    message: '该值无效 ',
    fields: {
        "name": {
            message: '名称无效',
            validators: {
                notEmpty: {
                    message: '站点名称无效 !'
                },
                stringLength: {
                    min: 3,
                    max: 20,
                    message: '站点名称长度为3到20个字符'
                }
            }
        }
    }
};


$(function () {
    //导出必须配置的两个量
    dataTableName = "#siteListTable";
    docName = "站点信息";
    mainObject = "site";


    initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "站点名称"}
    ];

    initBootGrid(dataTableName);


    validateForm().call(validationConfig);


    $("#searchBtn").trigger("click");

});


/**
 * 新增记录
 */
function add() {
    $("#myModal").modal("show");
}

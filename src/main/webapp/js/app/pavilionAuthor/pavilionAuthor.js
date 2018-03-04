/**
 * Created by huangbin on 2016/11/2.

 */


$(function () {


    //导出必须配置的两个量
    dataTableName = "#pavilionAuthorListTable";
    docName = "作者姓名";
    mainObject = "pavilionAuthor";


    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "作者姓名"}
    ];

    var grid = $(dataTableName).bootgrid({
        ajax: true,
        post: function () {
            return {
                id: "b0df282a-0d67-40e5-8558-c9e93b7befed"
            };
        },
        url: "/" + mainObject + "/data",
        formatters: {
            "upload": function (column, row) {
                return "<button type=\"button\" class=\"btn btn-xs btn-default command-upload\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-upload\"></span></button> "
            },
            "commands": function (column, row) {
                return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-pencil\"></span></button> " +
                    "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-trash-o\"></span></button>";
            }
        },
        converters: {
            datetime: {
                to: function (value) {
                    return transformYMD(value);
                }
            },
            showYes: {
                to: function (value) {
                    return value == '1' ? ("是") : " 否";
                }
            }
        }
    }).on("loaded.rs.jquery.bootgrid", function () {
        /* Executes after data is loaded and rendered */
        grid.find(".command-edit").on("click", function (e) {
            alert("You pressed edit on row: " + $(this).data("row-id"));
        }).end().find(".command-delete").on("click", function (e) {
            alert("You pressed delete on row: " + $(this).data("row-id"));
        }).end().find(".command-upload").on("click", function (e) {
            alert("You pressed upload on row: " + $(this).data("row-id"));
        });
    });


    $("#searchBtn").trigger("click");


});

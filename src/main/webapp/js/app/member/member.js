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

    // initBootGrid(dataTableName);


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
                    return value.substring(0, 7);
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

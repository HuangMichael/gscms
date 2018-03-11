/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {


//导出必须配置的两个量
    dataTableName = "#memberListTable";
    docName = "会员信息";
    mainObject = "member";


    // initSelect();

    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "name", "paramDesc": "会员名称"}
    ];

    var grid = $(dataTableName).bootgrid({
        selection: true,
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
                    return (value) ? "是" : "否";
                }
            },
            showStatus: {
                to: function (value) {
                    return (value) ? "有效" : "无效";
                }
            }
        }
    }).on("loaded.rs.jquery.bootgrid", function () {
        /* Executes after data is loaded and rendered */
        grid.find(".command-edit").on("click", function (e) {
            edit($(this).data("row-id"));
        }).end().find(".command-delete").on("click", function (e) {
            del($(this).data("row-id"));
        }).end().find(".command-upload").on("click", function (e) {
            showUpload();
        });
    });


    $("#searchBtn").trigger("click");


    formName = "#form";

    vdm = new Vue({
        el: formName,
        data: {
            member: null,
        }
    });


    $("#dropZone").dropzone({
        url: "/member/upload",
        addRemoveLinks: true,
        dictRemoveLinks: "移除文件",
        dictCancelUpload: "取消上传",
        maxFiles: 1,
        maxFilesize: 5,
        autoProcessQueue: true,
        acceptedFiles: ".jpg,.png",
        init: function () {
            this.on("success", function (file, data) {
                //上传完成后触发的方法
                console.log("file------------" + JSON.stringify(data));
                $("#dropZone").modal("hide");
            });
            this.on("removedfile", function (file) {
                console.log("File " + file.name + "removed");
            });
        }
    });


});


/**
 * 删除记录
 */
function del(id) {

    var url = getMainObject() + "/delete/" + id;
    if (id) {
        bootbox.confirm({
            message: "确定要删除该记录么？",
            buttons: {
                confirm: {
                    label: '确定',
                    className: 'btn-success'
                },
                cancel: {
                    label: '取消',
                    className: 'btn-danger'
                }
            },
            callback: function (result) {
                if (result) {
                    $.ajax({
                        type: "GET",
                        url: url,
                        success: function (msg) {
                            if (msg) {
                                showMessageBox("info", "记录删除成功！");
                                $(dataTableName).bootgrid("reload");
                            }
                        },
                        error: function (msg) {
                            showMessageBox("danger", "对不起，数据有关联，不能删除！ ");
                        }
                    });
                }
            }
        });
    }
}


/**
 * 删除记录
 */
function edit(id) {
    var object = findByIdAndObjectName(id, mainObject);

    console.log("member-----------------------" + JSON.stringify(object));
    vdm.$set("member", object);
    $("#editModal").modal("show");
}


/**
 * 显示上传下载
 */
function showUpload() {
    $("#uploadModal").modal("show");
}
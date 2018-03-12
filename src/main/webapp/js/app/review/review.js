/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */



$(function () {


//导出必须配置的两个量
    dataTableName = "#reviewListTable";
    docName = "内容审核信息";
    mainObject = "review";

    var recordId = null;


    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "title", "paramDesc": "标题名称"},
        {"param": "auditStatus", "paramDesc": "审核状态"}
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

            showImage: {
                to: function (value) {
                    return "<img src='" + value + "' class='img-circle'  style='height:25px;width: 25px'>";
                }
            },

            datetime: {
                to: function (value) {
                    return transformYMD(value);
                }
            },
            showYes: {
                to: function (value) {
                    return (value == ("1")) ? "是" : "否";
                }
            },
            showStatus: {
                to: function (value) {
                    return (value) ? "有效" : "无效";
                }
            },

            showAuditStatus: {
                to: function (value) {
                    var array = ["未审核", "初审通过", "复审通过", "终审通过", "已发布"]
                    return array[value];
                }
            },
            showMemberType: {
                to: function (value) {
                    return (value == "1") ? "国家会员" : "省级会员";
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
            recordId = $(this).data("row-id");
            showUpload();
        });
    });


    $("#searchBtn").trigger("click");


    formName = "#form";

    vdm = new Vue({
        el: formName,
        data: {
            review: null,
        }
    });


    $("#dropZone").dropzone({
        url: "/review/upload",
        addRemoveLinks: true,
        dictRemoveLinks: "移除文件",
        dictCancelUpload: "取消上传",
        maxFiles: 3,
        maxFilesize: 5,
        autoProcessQueue: true,
        acceptedFiles: ".jpg,.png",
        init: function () {
            this.on("success", function (file, data) {
                //上传完成后触发的方法
                if (data.result) {
                    $("#uploadModal").modal("hide");

                    $(dataTableName).bootgrid("reload");
                    showMessageBox("info", data["resultDesc"]);
                } else {
                    showMessageBox("danger", data["resultDesc"]);
                }
            });
            this.on('sending', function (file, xhr, formData) {
                //传递参数时在sending事件中formData，需要在前端代码加enctype="multipart/form-data"属性
                formData.append("mainObject", mainObject);
                formData.append("recordId", recordId);
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

    console.log("review-----------------------" + JSON.stringify(object));
    vdm.$set("review", object);
    $("#editModal").modal("show");
}


/**
 * 显示上传下载
 */
function showUpload() {
    $("#uploadModal").modal("show");
}
/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {


//�����������õ�������
    dataTableName = "#tableColumnConfigListTable";
    docName = "����������";
    mainObject = "tableColumnConfig";
    var recordId = null;


    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "colDesc", "paramDesc": "������"}
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
                    return (value == ("1")) ? "��" : "��";
                }
            },
            showStatus: {
                to: function (value) {
                    return (value) ? "��Ч" : "��Ч";
                }
            },
            showMemberType: {
                to: function (value) {
                    return (value == "1") ? "���һ�Ա" : "ʡ����Ա";
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
            tableColumnConfig: null,
        }
    });


    $("#dropZone").dropzone({
        url: "/member/upload",
        addRemoveLinks: true,
        dictRemoveLinks: "�Ƴ��ļ�",
        dictCancelUpload: "ȡ���ϴ�",
        maxFiles: 3,
        maxFilesize: 5,
        autoProcessQueue: true,
        acceptedFiles: ".jpg,.png",
        init: function () {
            this.on("success", function (file, data) {
                //�ϴ���ɺ󴥷��ķ���
                if (data.result) {
                    $("#uploadModal").modal("hide");

                    $(dataTableName).bootgrid("reload");
                    showMessageBox("info", data["resultDesc"]);
                } else {
                    showMessageBox("danger", data["resultDesc"]);
                }
            });
            this.on('sending', function (file, xhr, formData) {
                //���ݲ���ʱ��sending�¼���formData����Ҫ��ǰ�˴����enctype="multipart/form-data"����
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
 * ɾ����¼
 */
function del(id) {

    var url = getMainObject() + "/delete/" + id;
    if (id) {
        bootbox.confirm({
            message: "ȷ��Ҫɾ���ü�¼ô��",
            buttons: {
                confirm: {
                    label: 'ȷ��',
                    className: 'btn-success'
                },
                cancel: {
                    label: 'ȡ��',
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
                                showMessageBox("info", "��¼ɾ���ɹ���");
                                $(dataTableName).bootgrid("reload");
                            }
                        },
                        error: function (msg) {
                            showMessageBox("danger", "�Բ��������й���������ɾ���� ");
                        }
                    });
                }
            }
        });
    }
}


/**
 * ɾ����¼
 */
function edit(id) {
    var object = findByIdAndObjectName(id, mainObject);
    vdm.$set("tableColumnConfig", object);
    $("#editModal").modal("show");
}


/**
 * ��ʾ�ϴ�����
 */
function showUpload() {
    $("#uploadModal").modal("show");
}

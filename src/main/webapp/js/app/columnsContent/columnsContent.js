/**
 * Created by huangbin on 2018-3-1 09:46:42.

 */


$(function () {


//�����������õ�������
    dataTableName = "#columnsContentListTable";
    docName = "��Ŀ������Ϣ";
    mainObject = "columnsContent";


    var searchVue = new Vue({
        el: "#searchBox"
    });

    searchModel = [
        {"param": "title", "paramDesc": "����"}
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
                    return (value) ? "��" : "��";
                }
            },
            showStatus: {
                to: function (value) {
                    return (value) ? "��Ч" : "��Ч";
                }
            }
        }
    }).on("loaded.rs.jquery.bootgrid", function () {
        /* Executes after data is loaded and rendered */
        grid.find(".command-edit").on("click", function (e) {
            alert("You pressed edit on row: " + $(this).data("row-id"));
        }).end().find(".command-delete").on("click", function (e) {
            del($(this).data("row-id"));
        }).end().find(".command-upload").on("click", function (e) {
            showUpload();
        });
    });


    $("#searchBtn").trigger("click");


    vdm = new Vue({
        el: formName,
        data: {
            member: null,
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
    vdm.$set("member", object);
    $("#editModal").modal("show");
}


/**
 * ��ʾ�ϴ�����
 */
function showUpload() {
    $("#myModal").modal("show");
}






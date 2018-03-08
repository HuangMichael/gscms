<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container">
    <div class="row">
        <div id="content" class="col-lg-12">
            <!-- PAGE HEADER-->
            <%@include file="../common/common-breadcrumb.jsp" %>
            <div class="row">
                <div class="col-md-12">
                    <!-- BOX -->
                    <div class="box border blue">
                        <div class="box-title">
                            <h4><i class="fa fa-table"></i>会员信息</h4>
                        </div>
                        <%@include file="../common/common-menubar.jsp" %>
                        <div class="box-body">
                            <div id="contentDiv">
                                <div class="box-body">
                                    <div class="tabbable">
                                        <ul class="nav nav-tabs" id="myTab">
                                            <li class="active">
                                                <a href="#tab_1_0" data-toggle="tab">
                                                    <i class="fa fa-home" id="eq"></i>会员信息</a>
                                            </li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="form-group" style="margin-bottom:10px;position:inherit"
                                                 id="searchBox">
                                                <div class="col-md-2">
                                                    <input class="form-control" id="name"
                                                           name="name"
                                                           placeholder="会员名称"/>
                                                </div>
                                                <div class="col-md-2">
                                                    <button id="clearBtn" class="btn btn-default"
                                                            onclick="resetSearch()">清空
                                                    </button>
                                                    <button id="searchBtn" class="btn btn-default" onclick="search()">查询
                                                    </button>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade in active" id="tab_1_0">
                                                <table id="memberListTable"
                                                       class="table table-bordered table-hover table-striped">
                                                    <thead>
                                                    <tr>
                                                        <th data-column-id="id" data-type="numeric"
                                                            data-identifier="true" data-width="10%">序号
                                                        </th>
                                                        <th data-column-id="name" data-width="10%">会员名称</th>
                                                        <th data-column-id="cardNo" data-width="10%">会员证号</th>
                                                        <th data-column-id="enterDate" data-converter="datetime"
                                                            data-width="20%">加入时间
                                                        </th>
                                                        <th data-column-id="createTime" data-converter="datetime"
                                                            data-width="20%">创建时间
                                                        </th>
                                                        <th data-column-id="hasPhoto" data-width="10%"
                                                            data-converter="showYes">是否有照片
                                                        </th>
                                                        <th data-column-id="memberType" data-width="10%">会员类型</th>
                                                        <th data-column-id="status" data-width="10%"
                                                            data-converter="showStatus">状态
                                                        </th>
                                                        <th data-column-id="upload" data-formatter="upload"
                                                            data-sortable="false" data-width="8%">上传
                                                        </th>
                                                        <th data-column-id="commands" data-formatter="commands"
                                                            data-sortable="false" data-width="10%">编辑|删除
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                </table>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /BOX -->
                </div>
            </div>
            <%@include file="../common/common-back2top.jsp" %>
        </div>
        <!-- /CONTENT-->
    </div>
</div>


<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    上传
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-control">
                    <input type="file" name="file"/>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    上传
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<!-- 模态框（Modal） -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel1">
                    编辑记录
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-control">
                    <input type="file" name="file"/>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消
                </button>
                <button type="button" class="btn btn-primary">
                    保存
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<script type="text/javascript" src="/js/app/member/member.js"></script>

<%@ page contentType="text/html;charset=UTF-8" %>
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
                            <h4><i class="fa fa-table"></i>展馆作者</h4>
                        </div>
                        <%@include file="../common/common-menubar.jsp" %>
                        <div class="box-body">
                            <div id="contentDiv">
                                <div class="box-body">
                                    <div class="form-group" style="margin-bottom:10px;position:inherit"
                                         id="searchBox">
                                        <div class="col-md-2">
                                            <input class="form-control" id="name"
                                                   name="name"
                                                   placeholder="会员名称"/>
                                        </div>
                                        <div class="col-md-2">
                                            <button id="searchBtn" class="btn btn-default" onclick="search()">查询
                                            </button>
                                        </div>
                                    </div>
                                    <table id="pavilionAuthorListTable"
                                           class="table table-bordered table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <%@include file="tableList.jsp" %>
                                        </tr>
                                        </thead>
                                    </table>
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


<div class="modal fade " id="uploadModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span>&times;</span>
                </button>
                <h4 class="modal-title pull-left" id="myModalLabel2">请选择文件</h4>
            </div>
            <div class="modal-body">
                <div id="dropZone" class="dropzone"></div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/js/app/pavilionAuthor/pavilionAuthor.js"></script>

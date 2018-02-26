<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="http://yandex.st/highlightjs/7.3/styles/default.min.css">
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
                                    <div class="tabbable">
                                        <ul class="nav nav-tabs" id="myTab">
                                            <li class="active">
                                                <a href="#tab_1_0" data-toggle="tab">
                                                    <i class="fa fa-home" id="eq"></i>展馆作者</a>
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
                                                    <button id="searchBtn" class="btn btn-default" onclick="search()">查询
                                                    </button>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade in active" id="tab_1_0">
                                                <table id="memberListTable"
                                                       class="table table-bordered table-hover table-striped"
                                                       data-toggle="bootgrid" data-ajax="true"
                                                       data-url="/pavilionAuthor/data">
                                                    <thead>
                                                    <tr>
                                                        <th data-column-id="id" data-width="5%">序号</th>
                                                        <th data-column-id="name" data-width="8%">会员姓名</th>
                                                        <th data-column-id="cardNo" data-width="10%">会员编号</th>
                                                        <th data-column-id="createTime" data-width="20%">创建时间</th>
                                                        <th data-column-id="enterDate" data-width="10%">加入时间</th>
                                                        <th data-column-id="hasPhoto" data-width="12%">是否有照片</th>
                                                        <th data-column-id="sortNo" data-width="10%">排序</th>
                                                        <th data-column-id="status" data-width="5%">状态</th>
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
<script type="text/javascript" src="/js/app/pavilionAuthor/pavilionAuthor.js"></script>

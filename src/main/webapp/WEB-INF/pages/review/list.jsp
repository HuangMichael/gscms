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
                            <h4><i class="fa fa-table"></i>初审列表</h4>
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
                                                   placeholder="关键字"/>

                                            <select class="form-control" id="auditStatus">
                                                <option value="0">未审核</option>
                                                <option value="1">初审通过</option>
                                                <option value="2">复审通过</option>
                                                <option value="3">终审通过</option>
                                                <option value="4">已发布</option>
                                            </select>
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
                                        <table id="reviewListTable"
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
                    </div>
                    <!-- /BOX -->
                </div>
            </div>
            <%@include file="../common/common-back2top.jsp" %>
        </div>
        <!-- /CONTENT-->
    </div>
</div>
<script type="text/javascript" src="/js/app/review/review.js"></script>

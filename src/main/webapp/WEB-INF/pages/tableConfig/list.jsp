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
                            <h4><i class="fa fa-table"></i>数据表配置</h4>
                        </div>
                        <%@include file="../common/common-menubar.jsp" %>
                        <div class="box-body">
                            <div id="contentDiv">
                                <div class="box-body">

                                    <div class="form-group" style="margin-bottom:10px;position:inherit"
                                         id="searchBox">
                                        <div class="col-md-2">
                                            <input class="form-control" id="tableName"
                                                   name="tableName"
                                                   placeholder="表名称"/>
                                        </div>

                                        <div class="col-md-2">
                                            <select class="form-control" id="status" onchange="search()">
                                                <option value="1">有效</option>
                                                <option value="0">无效</option>
                                            </select>
                                        </div>
                                        <div class="col-md-2">
                                            <button id="searchBtn" class="btn btn-default" onclick="search()">
                                                查询
                                            </button>
                                        </div>
                                    </div>
                                    <table id="tableConfigListTable"
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
<script type="text/javascript" src="/js/app/tableConfig/tableConfig.js"></script>

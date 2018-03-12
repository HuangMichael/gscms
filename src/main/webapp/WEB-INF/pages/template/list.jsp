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
                            <h4><i class="fa fa-table"></i>模板管理</h4>
                        </div>
                        <%@include file="../common/common-menubar.jsp" %>
                        <div class="box-body">
                            <div id="contentDiv">
                                <div class="box-body">
                                    <div class="tabbable">
                                        <ul class="nav nav-tabs" id="myTab">
                                            <li class="active">
                                                <a href="#tab_1_0" data-toggle="tab">
                                                    <i class="fa fa-home" id="eq"></i>模板管理</a>
                                            </li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="form-group" style="margin-bottom:10px;position:inherit"
                                                 id="searchBox">
                                                <div class="col-md-2">
                                                    <input class="form-control" id="name"
                                                           name="name"
                                                           placeholder="关键字"/>
                                                </div>
                                                <div class="col-md-2">
                                                    <button id="searchBtn" class="btn btn-default" onclick="search()">查询
                                                    </button>
                                                </div>
                                            </div>
                                            <div class="tab-pane fade in active" id="tab_1_0">
                                                <table id="templateListTable"
                                                       class="table table-bordered table-hover table-striped"
                                                       data-toggle="bootgrid" data-ajax="true"
                                                       data-url="/template/data">
                                                    <thead>
                                                    <tr>


                                                        <%--@Column(length = 20, nullable = false)--%>
                                                        <%--private String templateName; //模板名称--%>

                                                        <%--@Column(length = 50, nullable = false)--%>
                                                        <%--private String templateUrl;//模板路径--%>

                                                        <%--@Column(length = 50, nullable = false)--%>
                                                        <%--private String templateDesc;//模板描述--%>


                                                        <%--@Column(length = 100, nullable = false)--%>
                                                        <%--private String fileName; //模板名称--%>

                                                        <%--@Column(length = 100, nullable = false)--%>
                                                        <%--private String fileUrl; //模板名称--%>


                                                        <%--@Column(length = 20, nullable = false)--%>
                                                        <%--private String sortNo;//排序--%>

                                                        <%--@Column(length = 1, nullable = false)--%>
                                                        <%--private String status;//状态--%>


                                                        <th data-column-id="id" data-width="5%">序号</th>

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
<script type="text/javascript" src="/js/app/template/template.js"></script>

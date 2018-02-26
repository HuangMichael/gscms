<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table id="siteListTable" class="table table-striped table-bordered table-hover" data-toggle="bootgrid" data-ajax="true"
       data-selection="true" data-multi-select="true" data-row-select="true" data-keep-selection="true"
       data-url="/site/data">
    <thead>
    <tr>
        <th data-column-id="id" data-identifier="true" data-type="numeric" data-align="center" data-width="5%">序号</th>
        <%--<th data-column-id="id" data-type="numeric" data-identifier="true" data-visible="false">ID</th>--%>
        <th data-column-id="name" data-sortable="true" data-width="10%">站点名称</th>
        <th data-column-id="domainName" data-sortable="true" data-width="10%">域名</th>
        <th data-column-id="deployHost" data-sortable="true" data-width="10%">主机名称</th>
        <th data-column-id="beginTime" data-sortable="true" data-width="10%">开始时间</th>
        <th data-column-id="endTime" data-sortable="true" data-width="10%">结束时间</th>
        <th data-column-id="sortNo" data-sortable="true" data-width="10%">排序</th>
        <th data-column-id="status" data-sortable="true" data-width="10%">状态</th>
    </tr>
    </thead>
</table>
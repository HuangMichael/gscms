<%@ page contentType="text/html;charset=UTF-8" %>
<th data-column-id="id" data-width="5%">序号</th>
<th data-column-id="id" data-type="numeric" data-identifier="true" data-visible="false" data-width="5%">ID</th>
<%--<th data-column-id="site" data-width="10%">站点</th>--%>
<%--<th data-column-id="columns" data-width="10%">栏目</th>--%>
<th data-column-id="title" data-width="15%">标题</th>
<%--<th data-column-id="content" data-width="10%">内容</th>--%>
<th data-column-id="focusPicUrl" data-width="10%">焦点图片</th>
<th data-column-id="createTime" data-width="10%" data-converter="datetime">创建时间</th>
<th data-column-id="creator" data-width="10%">创建人</th>
<th data-column-id="releaseTime" data-width="10%" data-converter="datetime">发布时间</th>
<th data-column-id="sortNo" data-width="5%">排序</th>
<th data-column-id="status" data-width="5%">状态</th>
<th data-column-id="auditStatus" data-width="10%" data-converter="showAuditStatus">审核状态</th>
<th data-column-id="upload" data-formatter="upload"
    data-sortable="false" data-width="6%">上传
</th>
<th data-column-id="commands" data-formatter="commands"
    data-sortable="false" data-width="10%">编辑|删除
</th>
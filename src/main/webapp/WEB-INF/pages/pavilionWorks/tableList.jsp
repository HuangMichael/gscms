<%@ page contentType="text/html;charset=UTF-8" %>
<th data-column-id="id" data-width="5%">序号</th>
<th data-column-id="id" data-type="numeric" data-identifier="true" data-visible="false" data-width="10%">ID</th>
<th data-column-id="name" data-width="8%">作品名称</th>
<th data-column-id="photoUrl" data-width="8%" data-converter="showImage">作品图片</th>

<%--<th data-column-id="columns" data-width="10%">所属栏目</th>--%>
<%--<th data-column-id="author" data-width="10%">作者名称</th>--%>
<th data-column-id="releaseTime" data-width="10%" data-converter="datetime">发行时间</th>
<th data-column-id="uploadTime" data-width="10%" data-converter="datetime">上传时间</th>
<%--<th data-column-id="isFocus" data-width="10%" data-converter="showYes">是否有照片</th>--%>
<th data-column-id="sortNo" data-width="10%">排序</th>
<th data-column-id="status" data-width="5%" data-converter="showStatus">状态</th>
<th data-column-id="upload" data-formatter="upload" data-sortable="false" data-width="8%">上传</th>
<th data-column-id="commands" data-formatter="commands"
    data-sortable="false" data-width="10%">编辑|删除
</th>

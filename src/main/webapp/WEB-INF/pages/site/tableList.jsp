<%@ page contentType="text/html;charset=UTF-8" %>
<th data-column-id="id" data-width="5%" data-align="center">序号</th>
<th data-column-id="name" data-width="10%">站点名称</th>
<th data-column-id="domainName" data-width="10%">域名</th>
<th data-column-id="deployHost" data-width="10%">部署服务器</th>
<th data-column-id="beginTime" data-width="10%" data-converter="datetime">生效时间</th>
<th data-column-id="endTime" data-width="10%" data-converter="datetime">失效时间</th>
<th data-column-id="sortNo" data-width="5%">排序</th>
<th data-column-id="status" data-width="5%" data-converter="showStatus">状态</th>
<th data-column-id="upload" data-formatter="upload"
    data-sortable="false" data-width="6%">上传
</th>
<th data-column-id="commands" data-formatter="commands"
    data-sortable="false" data-width="8%">编辑|删除
</th>
<%@ page contentType="text/html;charset=UTF-8" %>
<th data-column-id="id" data-type="numeric"
    data-identifier="true" data-width="6%">序号
</th>
<th data-column-id="name" data-width="10%">会员名称</th>
<th data-column-id="photoUrl" data-converter="showImage"
    data-width="6%">头像
</th>

<th data-column-id="cardNo" data-width="10%">会员证号</th>
<th data-column-id="enterDate" data-converter="datetime"
    data-width="15%">加入时间
</th>
<th data-column-id="createTime" data-converter="datetime"
    data-width="15%">创建时间
</th>
<th data-column-id="memberType" data-width="10%" data-converter="showMemberType">会员类型</th>
<th data-column-id="status" data-width="10%"
    data-converter="showStatus">状态
</th>
<th data-column-id="upload" data-formatter="upload"
    data-sortable="false" data-width="6%">上传
</th>
<th data-column-id="download" data-formatter="download" data-sortable="false" data-width="6%">下载</th>

<th data-column-id="commands" data-formatter="commands"
    data-sortable="false" data-width="10%">编辑|删除
</th>


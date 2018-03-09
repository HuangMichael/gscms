<%@ page contentType="text/html;charset=UTF-8" %>
<th data-column-id="id" data-type="numeric"
    data-identifier="true" data-width="10%">序号
</th>
<th data-column-id="name" data-width="10%">会员名称</th>
<th data-column-id="cardNo" data-width="10%">会员证号</th>
<th data-column-id="enterDate" data-converter="datetime"
    data-width="20%">加入时间
</th>
<th data-column-id="createTime" data-converter="datetime"
    data-width="20%">创建时间
</th>
<th data-column-id="hasPhoto" data-width="10%"
    data-converter="showYes">是否有照片
</th>
<th data-column-id="memberType" data-width="10%">会员类型</th>
<th data-column-id="status" data-width="10%"
    data-converter="showStatus">状态
</th>
<th data-column-id="upload" data-formatter="upload"
    data-sortable="false" data-width="8%">上传
</th>
<th data-column-id="commands" data-formatter="commands"
    data-sortable="false" data-width="10%">编辑|删除
</th>


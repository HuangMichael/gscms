<%@ page contentType="text/html;charset=UTF-8" %>
<#list columns as c>
<th data-column-id="${c.colName}" data-width="5%">${c.colDesc}</th>
</#list>


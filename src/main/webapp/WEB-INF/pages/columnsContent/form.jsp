<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form class="form-horizontal" id="form" method="post">
    <div class="form-group">
        <div class="col-md-12">
            <div class="form-group">
                <label for="title" class="col-md-2 control-label">标题</label>
                <div class="col-md-4">
                    <input class="form-control" id="title" name="title" v-model="columnsContent.title"/>
                </div>
                <label for="creator" class="col-md-2 control-label"> 创建人</label>
                <div class="col-md-4">
                    <input class="form-control" id="creator" name="title" v-model="columnsContent.creator"/>
                </div>
            </div>
            <%--<div class="form-group">--%>
            <%--<label for="beginTime" class="col-md-2 control-label">生效时间</label>--%>
            <%--<div class="col-md-4">--%>
            <%--<input class="form-control" id="beginTime" name="beginTime" v-model="columns.beginTime"/>--%>
            <%--</div>--%>
            <%--<label for="endTime" class="col-md-2 control-label">失效时间</label>--%>
            <%--<div class="col-md-4">--%>
            <%--<input class="form-control" id="endTime" name="beginTime" v-model="columns.endTime"/>--%>
            <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
            <%--<label for="status" class="col-md-2 control-label">状态</label>--%>
            <%--<div class="col-md-4">--%>
            <%--<input class="form-control" id="status" name="status" v-model="columns.status"/>--%>
            <%--</div>--%>
            <%--<label for="sortNo" class="col-md-2 control-label">排序</label>--%>
            <%--<div class="col-md-4">--%>
            <%--<input class="form-control" id="sortNo" name="sortNo" v-model="columns.sortNo"/>--%>
            <%--</div>--%>
            <%--</div>--%>


            <div class="form-group">
                <label for="creator" class="col-md-2 control-label">内容</label>
                <div class="col-md-10">
                    <textarea class="form-control" id="content1" name="title" v-model="columnsContent.content" rows="20" cols="40" />
                </div>
            </div>
        </div>
    </div>
</form>




<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form class="form-horizontal" id="form" method="post" action="/workOrder/save">
    <div class="form-group">
        <div class="col-md-12">
            <div class="form-group">
                <label for="name" class="col-md-2 control-label">站点名称</label>
                <div class="col-md-4">
                    <input class="form-control" id="name" name="name" v-model="columns.name"/>
                </div>
                <label for="type" class="col-md-2 control-label">栏目类型</label>
                <div class="col-md-4">
                    <input class="form-control" id="type" name="type" v-model="columns.type"/>
                </div>
            </div>
            <div class="form-group">
                <label for="beginTime" class="col-md-2 control-label">生效时间</label>
                <div class="col-md-4">
                    <input class="form-control" id="beginTime" name="beginTime" v-model="columns.beginTime"/>
                </div>
                <label for="endTime" class="col-md-2 control-label">失效时间</label>
                <div class="col-md-4">
                    <input class="form-control" id="endTime" name="beginTime" v-model="columns.endTime"/>
                </div>
            </div>
            <div class="form-group">
                <label for="status" class="col-md-2 control-label">状态</label>
                <div class="col-md-4">
                    <input class="form-control" id="status" name="status" v-model="columns.status"/>
                </div>
                <label for="sortNo" class="col-md-2 control-label">排序</label>
                <div class="col-md-4">
                    <input class="form-control" id="sortNo" name="sortNo" v-model="columns.sortNo"/>
                </div>
            </div>
        </div>
    </div>
</form>




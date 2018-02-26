<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal myform"  id="detailForm">
    <div class="form-group">
        <div class="col-md-2 col-sm-2 col-lg-2">
            <label for="name">站点名称</label>
        </div>
        <div class="col-md-4 col-sm-4 col-lg-4">
           <input class="form-control" id ="name" name ="name"  v-model="site.name">
        </div>
    </div>
    <div class="form-group">
        <%--<div class="col-md-2 col-sm-2 col-lg-2">--%>
            <%--<label for="locations_id">我的位置</label>--%>
        <%--</div>--%>
        <%--<div class="col-md-4 col-sm-4 col-lg-4">--%>
            <%--<select v-model="user.vlocations.id" class="form-control" id="locations_id" name="vlocations.id"--%>
                    <%--required style="width:100%" required>--%>
                <%--<template v-for="option in locs">--%>
                    <%--<option :value="option.id" v-if="option.id == user.vlocations.id" selected>--%>
                        <%--{{option.locName }}--%>
                    <%--</option>--%>
                    <%--<option :value="option.id" v-else>--%>
                        <%--{{option.locName }}--%>
                    <%--</option>--%>
                <%--</template>--%>
            <%--</select>--%>
        <%--</div>--%>

    <div class="col-md-2 col-sm-2 col-lg-2">
        <label for="status">状态</label>
    </div>
    <div class="col-md-4 col-sm-4 col-lg-4">
        <select class="form-control" id="status" name="status" required v-model="site.status" style="width:100%"
                required>
            <option value="1" selected>启用</option>
            <option value="0">禁用</option>
        </select>
    </div>
    </div>
    <div class="modal-footer">
        <button  id="saveBtn" name="saveBtn" class="btn btn-primary btn-danger">保存记录
        </button>
    </div>
</form>


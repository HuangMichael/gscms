<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form class="form-horizontal" id="form" method="post">
    <div class="form-group">
        <div class="col-md-12">
            <div class="form-group">
                <label for="name" class="col-md-2 control-label">会员名称</label>

                <div class="col-md-4">
                    <input class="form-control" id="name" name="name" v-model="member.name"/>
                </div>

                <label for="cardNo" class="col-md-2 control-label">会员证号</label>
                <div class="col-md-4">
                    <input class="form-control" id="cardNo" name="cardNo" v-model="member.cardNo"/>
                </div>
            </div>

            <div class="form-group">
                <label for="memberType" class="col-md-2 control-label">会员类型</label>
                <div class="col-md-4">
                    <input class="form-control" id="memberType" name="memberType" v-model="member.memberType"/>
                </div>

                <label for="status" class="col-md-2 control-label">会员状态</label>
                <div class="col-md-4">
                    <input class="form-control" id="status" name="status" v-model="member.status"/>
                </div>
            </div>
            <div class="form-group">
                <label for="enterDate" class="col-md-2 control-label">加入时间</label>
                <div class="col-md-4">
                    <input class="form-control" id="enterDate" type="date" name="enterDate" v-model="member.enterDate"/>
                </div>
                <label for="createTime" class="col-md-2 control-label">创建时间</label>
                <div class="col-md-4">
                    <input class="form-control" id="createTime" type="date" name="createTime"
                           v-model="member.enterDate"/>
                </div>
            </div>

        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default"
                data-dismiss="modal">关闭
        </button>
        <button type="button" id="saveWorkOrder" name="saveWorkOrder"
                class="btn btn-danger">保存
        </button>
    </div>
    </div>
</form>




<%@ page contentType="text/html;charset=UTF-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form class="form-horizontal" id="form" method="post">
    <div class="form-group">
        <div class="col-md-12">
            <div class="form-group">
                <label for="orderDesc" class="col-md-2 control-label">故障描述</label>
                <div class="col-md-4">
                    <input class="form-control" id="orderDesc" name="orderDesc"/>
                </div>

                <label for="reporter" class="col-md-2 control-label">报告人员</label>
                <div class="col-md-4">
                    <input class="form-control" id="reporter"
                           name="reporter"/>
                </div>
            </div>
            <div class="form-group">
                <label for="reportTelephone" class="col-md-2 control-label">报告电话</label>
                <div class="col-md-4">
                    <input class="form-control" id="reportTelephone"
                           name="reporter"/>
                </div>

                <label for="reportTime" class="col-md-2 control-label">报告时间</label>
                <div class="col-md-4">
                    <input class="form-control" id="reportTime" type="date" name="reportTime"/>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default"
                data-dismiss="modal">关闭
        </button>
        <button type="button" id="saveBtn"
                class="btn btn-danger">保存
        </button>
    </div>
    </div>
</form>




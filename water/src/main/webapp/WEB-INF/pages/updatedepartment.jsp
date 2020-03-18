<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function () {
        $("#updateDeptForm").submit(function () {
            $.post("/water/department/updateDepartment",$("#updateDeptForm").serialize(),function (data) {
                if (data.flag){
                    alert(data.data);
                    $.post("/water/page/department",{},function (data) {
                        var list = $("#list");
                        list.html(data);
                    })
                }else {
                    alert(data.data);
                    addDepartment();
                }
            });
            location.href="page/index";
            departmentManager();
        })
    });
    function departmentManager() {
        $.post("/water/page/department",{},function (data) {
            var list = $("#list");
            list.html(data);
            list.addClass("detailwindow");
        })
    }
</script>
<div class="row title">
    <p>部门信息</p>
</div>
<div class="row add-detail">
    <form class="form-horizontal" id="updateDeptForm">
        <div class="form-group">
            <input type="hidden" value="${department.dId}" id="dId" name="dId">
            <label for="departmentName" class="col-sm-2 control-label">部门名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="departmentName" name="departmentName" value="${department.departmentName}">
            </div>
        </div>
        <div class="form-group">
            <label for="departmentDesc" class="col-sm-2 control-label">职能说明</label>
            <div class="col-sm-10">
                <textarea cols="80" rows="5" id="departmentDesc" name="departmentDesc" >${department.departmentDesc}</textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-primary" onclick="departmentManager()";>返回</button>
            </div>
        </div>
    </form>
</div>



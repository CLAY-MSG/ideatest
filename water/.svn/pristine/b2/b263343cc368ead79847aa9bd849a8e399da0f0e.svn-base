<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function () {
        $("#updateRoleForm").submit(function () {
            $.post("/water/role/updateRole",$("#updateRoleForm").serialize(),function (data) {
                if (data.flag){
                    alert(data.data);
                    $.post("/water/page/role",{},function (data) {
                        var list = $("#list");
                        list.html(data);
                    })
                }else {
                    alert(data.data);
                    addRole();
                }
            });
            location.href="page/index";
            roleManager();
        })
    });
    function roleManager() {
        $.post("/water/page/role",{},function (data) {
            var list = $("#list");
            list.html(data);
            list.addClass("detailwindow");
        })
    }
</script>
<div class="row title">
    <p>角色信息</p>
</div>
<div class="row add-detail">
    <form class="form-horizontal" id="updateRoleForm">
        <div class="form-group">
            <input type="hidden" value="${role.rId}" id="rId" name="rId">
            <label for="roleName" class="col-sm-2 control-label">角色名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="roleName" name="roleName" value="${role.roleName}">
            </div>
        </div>
        <div class="form-group">
            <label for="roleDesc" class="col-sm-2 control-label">角色说明</label>
            <div class="col-sm-10">
                <textarea cols="80" rows="5" id="roleDesc" name="roleDesc" >${role.roleDesc}</textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-primary" onclick="roleManager()";>返回</button>
            </div>
        </div>
    </form>
</div>



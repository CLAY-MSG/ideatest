<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function () {
        var oldSex = $("#oldSex").val();
        var sexRadio1 = $("#sexRadio1");
        var sexRadio2 = $("#sexRadio2");
        var sexRadio1Val = sexRadio1.val();
        var sexRadio2Val = sexRadio2.val();
        if (sexRadio1Val === oldSex) {
            sexRadio1.attr("checked", true);
        } else if (sexRadio2Val === oldSex) {
            sexRadio2.attr("checked", true);
        }
        $.get("/water/department/departmentList", {}, function (departmentList) {
            var strs = "";
            var oldDepartmentName = $("#oldDepartmentName");
            for (var i = 0; i < departmentList.length; i++) {
                var department = departmentList[i];
                if (department.departmentName === oldDepartmentName) {
                    var str = "<option selected='selected' value='" + department.departmentName + "'>" + department.departmentName + "</option>";
                } else {
                    var str = "<option value='" + department.departmentName + "'>" + department.departmentName + "</option>";
                }
                strs += str;
            }
            $("#departmentName").html(strs);
        });
        $.get("/water/role/roleList", {}, function (roleList) {
            var strs = "";
            var oldRoleName = $("#oldRoleName");
            for (var i = 0; i < roleList.length; i++) {
                var role = roleList[i];
                if (role.roleName === oldRoleName) {
                    var str = "<option selected='selected' value='" + role.roleName + "'>" + role.roleName + "</option>";
                } else {
                    var str = "<option value='" + role.roleName + "'>" + role.roleName + "</option>";
                }
                strs += str;
            }
            $("#roleName").html(strs);
        });
    });
    $(function () {
        $("#updateUserForm").submit(function () {
            $.post("/water/user/updateUser", $("#updateUserForm").serialize(), function (data) {
                if (data.flag) {
                    alert(data.data);
                    $.post("/water/page/user", {}, function (data) {
                        var list = $("#list");
                        list.html(data);
                        list.addClass("detailwindow");
                    })
                } else {
                    alert(data.data);
                }
            });
            location.href = "page/index";
            userManager();
        })
    });

    function userManager() {
        $.post("/water/page/user", {}, function (data) {
            var list = $("#list");
            list.html(data);
            list.addClass("detailwindow");
        })
    }
</script>
<div class="row title">
    <p>用户信息</p>
</div>
<div class="row add-detail">
    <form class="form-horizontal" id="updateUserForm">
        <input type="hidden" value="${user.uId}" id="uId" name="uId">
        <input type="hidden" value="${user.departmentName}" id="oldDepartmentName">
        <input type="hidden" value="${user.roleName}" id="oldRoleName">
        <input type="hidden" value="${user.sex}" id="oldSex">
        <div class="form-group">
            <label class="col-sm-2 control-label">性别</label>
            <div class="radio col-sm-10">
                <label class="radio-inline">
                    <input type="radio" name="sex" id="sexRadio1" value="男"> 男
                </label>
                <label class="radio-inline">
                    <input type="radio" name="sex" id="sexRadio2" value="女"> 女
                </label>

            </div>
        </div>
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">登录名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" name="username" value="${user.username}">
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">姓名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="name" name="name" value="${user.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="telephone" class="col-sm-2 control-label">联系电话</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="telephone" name="telephone" value="${user.telephone}">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="email" name="email" value="${user.email}">
            </div>
        </div>
        <div class="form-group">
            <label for="department" class="col-sm-2 control-label">所属部门</label>
            <div class="col-sm-10">
                <select class="form-control" id="department" name="departmentName">
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="role" class="col-sm-2 control-label">角色设置</label>
            <div class="col-sm-10">
                <select multiple class="form-control" id="role" name="roleName">
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="userDesc" class="col-sm-2 control-label">个人备注</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="3" id="userDesc" name="userDesc">${user.userDesc}</textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>
                <button type="button" class="btn btn-primary" onclick="userManager()" ;>返回</button>
            </div>
        </div>
    </form>
</div>



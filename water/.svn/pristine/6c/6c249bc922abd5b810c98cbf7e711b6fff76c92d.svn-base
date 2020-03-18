<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $.post("/water/role/roleList", {}, function (roleList) {
            var trs = "";
            for (var i = 0; i < roleList.length; i++) {
                var roleVar = roleList[i];
                var djs = "javascript:deleteRole(\""+roleVar.roleName+"\")";
                var ujs = "javascript:updateRole(\""+roleVar.rId+"\",\""+roleVar.roleName+"\",\""+roleVar.roleDesc+"\")";
                var tr = "<tr><td>" + (i+1) + "</td><td>" + roleVar.roleName + "</td><td>" + roleVar.roleDesc + "</td><td><a href='"+djs+"'>删除</a>  <a href='"+ujs+"'>修改</a></td></tr>";
                trs += tr;
            }
            $("#roleList").html(trs);
        })
    });

    function addRole() {
        $.get("/water/page/addrole", {}, function (data) {
            $("#list").html(data);
        })
    }

    function deleteRole(roleName) {
        var confirm = window.confirm("您确定要删除吗？");
        if (confirm){
            $.get("/water/role/deleteRole",{roleName:roleName}, function (data) {
                alert("删除成功");
                $.post("/water/page/role",{},function (data) {
                    var list = $("#list");
                    list.html(data);
                })
                // location.reload();
            })
        }

    }

    function updateRole(rId,roleName,roleDesc) {
        $.get("/water/page/updaterole", {rId:rId,roleName:roleName,roleDesc:roleDesc}, function (data) {
            $("#list").html(data);
        })
    }
</script>

<div class="row">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">>角色管理</div>
        <!-- Table -->
        <table class="table table-hover table-bordered">
            <thead>
            <tr style="background-color: #b6d9ea">
                <td>序号</td>
                <td>角色名称</td>
                <td>角色说明</td>
                <td>相关操作</td>
            </tr>
            </thead>
            <tbody id="roleList">
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <input type="button" class="btn btn-default btn-primary" onclick="addRole()" value="新建"
           style="margin-left: 20px">
</div>



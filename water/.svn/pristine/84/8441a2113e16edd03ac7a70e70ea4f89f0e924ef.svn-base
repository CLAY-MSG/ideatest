<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        $.post("/water/department/departmentList", {}, function (departmentList) {
            var trs = "";
            for (var i = 0; i < departmentList.length; i++) {
                var departmentVar = departmentList[i];
                var djs = "javascript:deleteDepartment(\""+departmentVar.departmentName+"\")";
                var ujs = "javascript:updateDepartment(\""+departmentVar.dId+"\",\""+departmentVar.departmentName+"\",\""+departmentVar.departmentDesc+"\")";
                var tr = "<tr><td>" + (i+1) + "</td><td>" + departmentVar.departmentName + "</td><td>" + departmentVar.departmentDesc + "</td><td><a href='"+djs+"'>删除</a>  <a href='"+ujs+"'>修改</a></td></tr>";
                trs += tr;
            }
            $("#departmentList").html(trs);
        })
    });

    function addDepartment() {
        $.get("/water/page/adddepartment", {}, function (data) {
            $("#list").html(data);
        })
    }

    function deleteDepartment(departmentName) {
        var confirm = window.confirm("您确定要删除吗？");
        if (confirm){
            $.get("/water/department/deleteDepartment",{departmentName:departmentName}, function (data) {
                alert("删除成功");
                $.post("/water/page/department",{},function (data) {
                    var list = $("#list");
                    list.html(data);
                    list.addClass("detailwindow");
                })
                // location.reload();
            })
        }

    }

    function updateDepartment(dId,departmentName,departmentDesc) {
        $.get("/water/page/updatedepartment", {dId:dId,departmentName:departmentName,departmentDesc:departmentDesc}, function (data) {
            $("#list").html(data);
        })
    }
</script>

<div class="row">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">>部门管理</div>
        <!-- Table -->
        <table class="table table-hover table-bordered">
            <thead>
            <tr style="background-color: #b6d9ea">
                <td>序号</td>
                <td>部门名称</td>
                <td>部门说明</td>
                <td>相关操作</td>
            </tr>
            </thead>
            <tbody id="departmentList">
            </tbody>
        </table>
    </div>
</div>
<div class="row">
    <input type="button" class="btn btn-default btn-primary" onclick="addDepartment()" value="新建"
           style="margin-left: 20px">
</div>



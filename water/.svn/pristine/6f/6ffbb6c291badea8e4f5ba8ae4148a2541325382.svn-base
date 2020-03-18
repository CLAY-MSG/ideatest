<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    function departmentManager() {
        $.post("/water/page/department",{},function (data) {
            var list = $("#list");
            list.html(data);
            list.addClass("detailwindow");
        })
    }
    function roleManager() {
        $.post("/water/page/role",{},function (data) {
            var list = $("#list");
            list.html(data);
            list.addClass("detailwindow");
        })
    }
    function usersManager() {
        $.post("/water/page/user",{},function (data) {
            var list = $("#list");
            list.html(data);
            list.addClass("detailwindow");
        })
    }
    function newsManager() {
        $.post("/water/page/news",{},function (data) {
            var list = $("#list");
            list.html(data);
            list.addClass("detailwindow");
        })
    }
</script>
<div class="nav left-nav left">
    <ul class="nav nav-pills nav-stacked">
        <li id="sysmanage" role="presentation"><a href="javascript:void(0)">系统管理</a></li>
        <li id="depmanage" role="presentation"><a href="javascript:departmentManager()">部门管理</a></li>
        <li id="rolemanage" role="presentation"><a href="javascript:roleManager()">角色管理</a></li>
        <li id="usermanage" role="presentation"><a href="javascript:usersManager()">用户管理</a></li>
        <li id="newsmanage" role="presentation"><a href="javascript:newsManager()">新闻管理</a></li>
    </ul>
</div>


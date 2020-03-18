<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    $(function () {
        loadPage(null, null);
    });

    function submitForm() {
        var currentPage = getParameter("currentPage");
        var pageSize = $("#pageSize").val();
        loadPage(currentPage, pageSize);
    }

    function loadPage(currentPage, pageSize) {
        var post = $.post("/water/user/userList", {
            currentPage: currentPage,
            pageSize: pageSize
        }, function (userPageBean) {
            var totalCount = userPageBean.totalCount;
            var totalPage = userPageBean.totalPage;
            var currentPage = userPageBean.currentPage;
            var pageSize = userPageBean.pageSize;
            $('#span_totalPage').html(currentPage + "/" + totalPage);
            $('#sapn_totalCount').html(totalCount);
            var strs = "";
            var userList = userPageBean.pageContent;
            var pId = (currentPage - 1) * pageSize + 1;
            for (var i = 0; i < userList.length; i++) {
                var user = userList[i];
                var djs = "javascript:deleteUser(\"" + user.uId + "\")";
                var ujs = "javascript:updateUser('" + JSON.stringify(user) + "')";
                var str = "<tr><td>" + pId + "</td><td>" + user.username + "</td><td>" + user.name + "</td><td>" + user.departmentName + "</td><td>" + user.roleName + "</td><td>" + user.userDesc + "</td><td>" + user.telephone + "</td><td><a href='" + djs + "'>删除</a>  <a href=" + ujs + ">修改</a></td></tr>";
                pId++;
                strs += str;
            }
            var uuser = userList[3];
            $("#userList").html(strs);

            var lis = "";
            var firstPage = '<li onclick="loadPage(1,' + pageSize + ')"><a href="javascript:void(0)">首页</a></li>';
            lis += firstPage;
            if (currentPage > 1) {
                var beforePage = '<li onclick="loadPage(' + (currentPage - 1) + ',' + pageSize + ')" class="threeword"><a href="javascript:void(0)">上一页</a></li>';
                lis += beforePage;
            }
            var begin;
            var end;
            if (totalPage < 10) {
                begin = 1;
                end = totalPage;
            } else {
                begin = currentPage - 5;
                end = currentPage + 4;
                if (begin < 1) {
                    begin = 1;
                    end = begin + 9;
                }
                if (end > totalPage) {
                    end = totalPage;
                    begin = end - 9;
                }
            }
            for (var j = begin; j <= end; j++) {
                var li = '';
                if (j === currentPage) {
                    li = '<li class="curPage" onclick="loadPage(' + j + ',' + pageSize + ')"><a href="javascript:void(0)">' + j + '</a></li>';
                } else {
                    li = '<li onclick="loadPage(' + j + ',' + pageSize + ')"><a href="javascript:void(0)">' + j + '</a></li>';

                }
                lis += li;
            }

            if (currentPage < totalPage) {
                var nextPage = '<li onclick="loadPage(' + (currentPage + 1) + ',' + pageSize + ')" class="threeword"><a href="javascript:void(0)">下一页</a></li>';
                lis += nextPage;
            }
            var endPage = '<li onclick="loadPage(' + totalPage + ',' + pageSize + ')" class="threeword"><a href="javascript:void(0)">末页</a></li>';

            lis += endPage;
            $('#pageNum').html(lis);
        })
    }

    function addUser() {
        $.get("/water/page/adduser", {}, function (data) {
            $("#list").html(data);
        })
    }

    function deleteUser(uId) {
        var confirm = window.confirm("您确定要删除吗？");
        if (confirm) {
            $.get("/water/user/deleteUser", {uId: uId}, function (data) {
                alert("删除成功");
                $.post("/water/page/user", {}, function (data) {
                    var list = $("#list");
                    list.html(data);
                    list.addClass("detailwindow");
                })
                // location.reload();
            })
        }

    }

    function updateUser(user) {
        $.ajax({
            type: "post",
            url: "/water/page/updateuser",
            contentType: "application/json;charset=utf-8",
            data: user,
            success: function (data) {
                $("#list").html(data);

                },
            }
        );
    }
</script>

<div class="row">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">>用户管理</div>
        <!-- Table -->
        <table class="table table-hover table-bordered">
            <thead>
            <tr style="background-color: #b6d9ea">
                <td>序号</td>
                <td>用户名</td>
                <td>姓名</td>
                <td>所属部门</td>
                <td>职位</td>
                <td>备注</td>
                <td>电话</td>
                <td>相关操作</td>
            </tr>
            </thead>
            <tbody id="userList">
            </tbody>
        </table>
    </div>
</div>
<div class="row" style="line-height: 25px">
    <div class="col-sm-6" style="height: 25px; line-height: 25px">
        <input type="button" class="btn btn-default btn-primary" onclick="addUser()" value="新建"
               style="margin-left: 20px;margin-right: 20px">
        页次：<span id="span_totalPage"></span>页
        <label for="pageSize">每页显示：</label>
        <select id="pageSize" name="pageSize" onchange="submitForm()">
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>条
        总记录条数：<span id="sapn_totalCount"></span>条
    </div>
    <nav aria-label="Page navigation" class="col-sm-6" style="text-align: right;right:50px;top:-25px ">
        <ul class="pagination" id="pageNum">
        </ul>
    </nav>
</div>





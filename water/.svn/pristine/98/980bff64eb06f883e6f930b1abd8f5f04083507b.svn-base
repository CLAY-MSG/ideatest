<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>十三五水专项项目管理系统</title>
    <!-- 1. 导入CSS的全局样式 -->
    <!-- 1. 导入CSS的全局样式 -->
    <link href=${pageContext.request.contextPath}/css/bootstrap.min.css rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src=${pageContext.request.contextPath}/js/jquery-3.3.1.js></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src=${pageContext.request.contextPath}/js/bootstrap.min.js></script>
    <script src=${pageContext.request.contextPath}/js/getParameter.js></script>

    <script type="text/javascript" src=${pageContext.request.contextPath}/js/include.js></script>
    <script src=${pageContext.request.contextPath}/js/ckeditor/ckeditor.js type="text/javascript" charset="utf-8"></script>
    <link href=${pageContext.request.contextPath}/css/common.css rel="stylesheet">

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
            var post = $.post("/water/user/online", {
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
                    var str = "<tr><td>" + pId + "</td><td>" + user.name + "</td><td>" + user.telephone + "</td><td>" + user.userDesc + "</td><td>" + user.departmentName + "</td><td>" + user.statu + "</td></tr>";
                    pId++;
                    strs += str;
                }
                $("#onlineUser").html(strs);

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
    </script>
</head>
<body>
<div class="container-fluid container-body">
    <div id="header" class="row header"></div>
    <div class="row margin index-body">
        <div id="lefter" class="col-sm-1" style="padding: 0"></div>
        <div id="list" class="col-sm-11 margin">
            <div class="row">
                <div class="panel panel-default">
                    <!-- Default panel contents -->
                    <div class="panel-heading">>当前在线用户列表</div>
                    <!-- Table -->
                    <table class="table table-hover">
                        <thead>
                        <tr style="background-color: #b6d9ea">
                            <td>序号</td>
                            <td>用户名称</td>
                            <td>手机号</td>
                            <td>说明</td>
                            <td>单位名称</td>
                            <td>状态</td>
                        </tr>
                        </thead>
                        <tbody id="onlineUser">
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row" style="line-height: 25px">
                <div class="col-sm-6"style="height: 25px; line-height: 25px">
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
        </div>
    </div>


</div>


</body>
</html>

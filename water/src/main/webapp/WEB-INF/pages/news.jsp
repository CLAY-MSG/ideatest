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
        var post = $.post("/water/news/newsList", {
            currentPage: currentPage,
            pageSize: pageSize
        }, function (newsPageBean) {
            var totalCount = newsPageBean.totalCount;
            var totalPage = newsPageBean.totalPage;
            var currentPage = newsPageBean.currentPage;
            var pageSize = newsPageBean.pageSize;
            $('#span_totalPage').html(currentPage + "/" + totalPage);
            $('#sapn_totalCount').html(totalCount);
            var strs = "";
            var newsList = newsPageBean.pageContent;
            var pId = (currentPage - 1) * pageSize + 1;
            for (var i = 0; i < newsList.length; i++) {
                var news = newsList[i];
                var djs = "javascript:deleteNews(\"" + news.nId + "\")";
                var ujs = "javascript:updateNews('" + JSON.stringify(news) + "')";
                var str = "<tr><td>" + pId + "</td><td>" + news.newsTitle + "</td><td>" + news.uploadDate + "</td><td>" + news.newsStatus + "</td><td>" + news.newsUploadUser.name + "</td><td><a href='" + ujs + "'>编辑</a>  <a href=" + djs + ">删除</a></td></tr>";
                pId++;
                strs += str;
            }
            $("#newsList").html(strs);

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

    function addNews() {
        $.get("/water/page/addnews", {}, function (data) {
            $("#list").html(data);
        })
    }

    function deleteNews(nId) {
        var confirm = window.confirm("您确定要删除吗？");
        if (confirm) {
            $.get("/water/news/deleteNews", {nId: nId}, function (data) {
                alert("删除成功");
                $.post("/water/page/news", {}, function (data) {
                    var list = $("#list");
                    list.html(data);
                    list.addClass("detailwindow");
                })
                // location.reload();
            })
        }

    }

    function updateNews(news) {
        $.ajax({
            type: "post",
            url: "/water/page/updatenews",
            contentType: "application/json;charset=utf-8",
            data: news,
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
        <div class="panel-heading">>新闻管理</div>
        <!-- Table -->
        <table class="table table-hover table-bordered">
            <thead>
            <tr style="background-color: #b6d9ea">
                <td>序号</td>
                <td>标题</td>
                <td>上传时间</td>
                <td>状态</td>
                <td>上传者</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody id="newsList">
            </tbody>
        </table>
    </div>
</div>
<div class="row" style="line-height: 25px">
    <div class="col-sm-6" style="height: 25px; line-height: 25px">
        <input type="button" class="btn btn-default btn-primary" onclick="addNews()" value="新建"
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





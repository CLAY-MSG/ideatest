<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>用户信息列表</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
    <style>
        tr,td{
            text-align: center;
        }
    </style>
    <script>
        function deleteUser(deleteUserId) {
            if (confirm("您确定要删除吗？")){
                location.href="${pageContext.request.contextPath}/DelUserByIdServlet?userId="+deleteUserId;
            }
        }

        window.onload = function () {
            document.getElementById("delSelected").onclick = function () {
                if (confirm("您确定要删除所选内容吗?")){
                    var flag = false;
                    var cbs = document.getElementsByName("selected");
                    for (var i = 0; i < cbs.length; i++) {
                        if(cbs[i].checked){
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        document.getElementById("form").submit();
                    }
                }
            }
            document.getElementById("selectAll").onclick = selectUser;
            function selectUser(){
                var cbs = document.getElementsByName("selected");
                for (var i = 0; i < cbs.length; i++) {
                    cbs[i].checked = this.checked;
                }
            }
            let selectAllBtn = document.getElementById(`selectAllBtn`);
            selectAllBtn.onclick = function () {
                var cbs = document.getElementsByName("selected");
                for (var i = 0; i < cbs.length; i++) {
                    cbs[i].checked = true;
                }
            }
            let notSelectAllBtn = document.getElementById(`notSelectAllBtn`);
            notSelectAllBtn.onclick = function () {
                var cbs = document.getElementsByName("selected");
                for (var i = 0; i < cbs.length; i++) {
                    cbs[i].checked = false;
                }
            }

            let reverseSelectBtn = document.getElementById(`reverseSelectBtn`);
            reverseSelectBtn.onclick = function () {
                var cbs = document.getElementsByName("selected");
                for (var i = 0; i < cbs.length; i++) {
                    if (cbs[i].checked === true){
                        cbs[i].checked = false;
                    } else{
                        cbs[i].checked = true;
                    }
                }
            }

        }


    </script>
    <style>
        .paddingtop{
            padding-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row" style="text-align: center">
       <h3 >用户信息列表</h3>
    </div>
    <div class="row paddingtop">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" id="exampleInputName2" name="searchName">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">籍贯</label>
                <input type="email" class="form-control" id="exampleInputEmail2" name="searchAddress">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail3">Email</label>
                <input type="email" class="form-control" id="exampleInputEmail3" name="searchEmail">
            </div>
            <button type="submit" class="btn btn-primary"><span style="font-weight: bold">查询</span></button>
        </form>
    </div>
    <div class="row">
        <button type="button" class="btn btn-primary" id="selectAllBtn">全选</button>
        <button type="button" class="btn btn-primary" id="reverseSelectBtn">反选</button>
        <button type="button" class="btn btn-primary" id="notSelectAllBtn" >全不选</button>
        <a type="button" href="javaScript:void(0)" class="btn btn-primary" id="delSelected" >删除选中</a>
        <a type="button" href="add.jsp" class="btn btn-primary" >添加联系人</a>
    </div>
    <div class="row paddingtop" >
        <form id="form" action="${pageContext.request.contextPath}/DelSelectedUserServlet" method="post">
            <table class="table table-responsive table-bordered table-hover">
                <tr style="background-color: #dff0d8;font-weight: 600">
                    <td>
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" id="selectAll">
                            </label>
                        </div>
                    </td>
                    <td>编号</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>年龄</td>
                    <td>籍贯</td>
                    <td>QQ</td>
                    <td>邮箱</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${pb.list}" var="user" varStatus="s">
                    <tr>
                        <td>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="selected" value="${user.id}">
                                </label>
                            </div>
                        </td>
                        <td>${s.count}</td>
                        <td>${user.username}</td>
                        <td>${user.gender}</td>
                        <td>${user.age}</td>
                        <td>${user.address}</td>
                        <td>${user.qq}</td>
                        <td>${user.email}</td>
                        <td>
                            <a type="button" class="btn btn-default" href="${pageContext.request.contextPath}/FindUserByIdServlet?userId=${user.id}&" >修改</a>
                            <a type="button" class="btn btn-default" href="javascript:deleteUser(${user.id});" id="deleteUser">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
    <div class="row paddingtop">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px">
                    共16条记录，共4页
                </span>
            </ul>
        </nav>

    </div>
</div>



</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>登录</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
    <script type="text/javascript">
        function refresh() {
            var checkcode_img = document.getElementById("checkcode_img");
            checkcode_img.src = "${pageContext.request.contextPath}/CheckCodeServlet?time="+new Date().getTime();
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row" style="text-align: center">
        <h3>登录</h3>
    </div>
    <div class="row" >
        <form class="form-horizontal" action="${pageContext.request.contextPath}/LoginUserServlet" method="post">
            <div class="form-group">
                <label for="username" class="col-sm-offset-2 col-sm-2 control-label">用户名</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="username" id="username" placeholder="请输入用户名">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-offset-2 col-sm-2 control-label">密码</label>
                <div class="col-sm-4">
                    <input type="password" class="form-control" name="password" id="password" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <label for="checkcode" class="col-sm-offset-2 col-sm-2 control-label">验证码</label>
                <div class="col-sm-4">
                    <input type="text" name="checkcode" id="checkcode" class="form-control" placeholder="请输入验证码">
                </div>
                <div class="col-sm-3">
                    <img src="${pageContext.request.contextPath}/CheckCodeServlet" id="checkcode_img">
                    <a href="javascript:refresh()">看不清刷新一下</a>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-8">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> Remember me
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="" style="text-align: center">
                    <button type="submit" class="btn btn-default">登录</button>
                    <button type="reset" class="btn btn-default">重置</button>
                </div>
            </div>
        </form>
    </div>
    <div class="row">
        <div class="col-sm-offset-4 col-sm-4">
            <div class="alert alert-warning alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" >
                    <span style="">&times;</span>
                </button>
                <strong>${login_msg}</strong>
            </div>
        </div>
    </div>

</div>
</body>
</html>

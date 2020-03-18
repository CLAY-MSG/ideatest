<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Title</title>
    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center;">添加联系人</h3>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/AddUserServlet" method="post">
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">姓名：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="username" name="username" placeholder="请输入姓名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">性别：</label>
            <div class="col-sm-10">
                <label class="radio-inline">
                    <input type="radio" name="gender" id="male" value="男" checked = "checked"> 男
                </label>
                <label class="radio-inline">
                    <input type="radio" name="gender" id="female" value="女"> 女
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="age" class="col-sm-2 control-label">年龄：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="age" id="age" placeholder="请输入年龄">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">籍贯：</label>
            <div class="col-sm-10">
                <select class="form-control" name="address">
                    <option name="address" value="北京">北京</option>
                    <option name="address" value="上海">上海</option>
                    <option name="address" value="广东">广东</option>
                    <option name="address" value="深圳">深圳</option>
                    <option name="address" value="杭州">杭州</option>
                    <option name="address" value="郑州">郑州</option>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="qq" class="col-sm-2 control-label">QQ：</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="qq" id="qq" placeholder="请输入QQ">
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">Email：</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" name="email" id="email" placeholder="请输入Email">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-12" style="text-align: center">
                <button type="submit" class="btn btn-primary">提交</button>
                <button type="reset" class="btn btn-default">重置</button>
                <a type="button" class="btn btn-default">返回</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>

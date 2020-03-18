<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>修改联系人</title>
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
    <div class="row">
        <div class="col-md-12" style="text-align: center">
            <h3>修改联系人</h3>
        </div>
    </div>
    <div class="row">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/UpdateUserServlet" method="post">
            <input type="hidden" value="${user.id}" name="id">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">姓名：</label>
                <div class="col-sm-10">
                    <input type="text" readonly="readonly" class="form-control" id="username" name="username" value="${user.username}" placeholder="请输入用户名">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">性别：</label>
                <div class="col-sm-10">
                    <label class="radio-inline">
                        <c:if test="${user.gender == '男'}">
                            <input type="radio" name="gender" id="male" value="男" checked = "checked"> 男
                        </c:if>
                        <c:if test="${!(user.gender == '男')}">
                            <input type="radio" name="gender" id="male" value="男" > 男
                        </c:if>

                    </label>
                    <label class="radio-inline">
                        <c:if test="${user.gender == '女'}">
                            <input type="radio" name="gender" id="female" value="女" checked="checked"> 女
                        </c:if>
                        <c:if test="${!(user.gender == '女')}">
                            <input type="radio" name="gender" id="female" value="女"> 女
                        </c:if>

                    </label>
                </div>
            </div>
            <div class="form-group">
                <label for="age" class="col-sm-2 control-label">年龄：</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="age" id="age" value="${user.age}" placeholder="请输入年龄">
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
                    <input type="text" class="form-control" name="qq" id="qq" value="${user.qq}" placeholder="请输入QQ">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">Email：</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" name="email" id="email" value="${user.email}" placeholder="请输入Email">
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
</div>
</body>
</html>

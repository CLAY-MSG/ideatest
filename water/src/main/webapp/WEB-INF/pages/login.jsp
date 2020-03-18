<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

    <title>十三五水专项项目管理系统</title>
    <script src=${pageContext.request.contextPath}/js/jquery-3.3.1.js></script>
    <script type="text/javascript">
        $(function () {
            $("#login_btn").click(function () {
                $.post("user/login",$('#login_form').serialize(),function (data) {
                    if (data.flag) {
                        location.href = "page/index";
                    }else {
                        $('#errorMsg').html(data.errorMsg);
                    }
                })
            })
        })
    </script>

    <style type="text/css">
        body{
            background: url(${pageContext.request.contextPath}/images/水专项登陆界面1.png);
        }
        .login_div{
            width: 270px;
            height: 200px;
            margin-top: 420px;
            margin-left: 1150px;
            text-align: center;
        }
        .padding-top{
            padding-top: 20px;
        }
    </style>
</head>
<body>
<div class="login_div padding-top">
    <form id="login_form">
        <p id="errorMsg" style="color: red"></p>
        <label for="username">账户</label>
        <input type="text" id="username" name="username" placeholder="请输入用户名">
        <br>
        <br>
        <label for="password">密码</label>
        <input type="password" id="password" name="password" placeholder="请输入密码">
        <br>
        <br>
        <button type="button" id="login_btn">登录</button>
    </form>
</div>

</body>
</html>

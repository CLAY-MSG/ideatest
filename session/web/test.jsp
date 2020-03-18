<%--
  Created by IntelliJ IDEA.
  User: 小米
  Date: 2020/1/7
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>

    //------------------------
    var board = new PIXI.Sprite.fromImage("res/lianxi/zhuan/img-1_82.png");
    app.stage.addChild(board);
    board.x = 250;
    board.y = 500;

    //设置图片锚点
    board.anchor.x = 0.5;
    board.anchor.y = 0.5;


    bg.interactive = true;
    bg.on("mousemove", movePlayer);
    function movePlayer(event) {
        var pos = event.data.getLocalPosition(app.stage);
        board.x = pos.x;
        board.y = pos.y;
    }


</script>
</body>
<style>
    body{
        background-color: black;
    }
</style>
</html>

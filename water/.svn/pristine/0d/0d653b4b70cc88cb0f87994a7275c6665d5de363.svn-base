<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<script>
    $(function () {
        //自定义CKEditor
        CKEDITOR.replace("newsText", {
            language: 'zh-cn',
            uiColor: '#91c0e3',
            height: 245,
            defaultLanguage: 'zh-cn',
            //提交时自动更新元素
            autoUpdateElement: true,
            //工具栏设置
            toolbar: [
                ['FontSize'],
                ['Bold', 'Italic', 'Underline', 'Strike'],
                ['Subscript', 'Superscript'],
                ['TextColor', 'BGColor'],
                ['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
                ['Outdent', 'Indent'],
                ['Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord'],
                ['Undo', 'Redo'],
                ['SelectAll', 'RemoveFormat'],
                ['NumberedList', 'HorizontalRule'],
                ['Maximize']
            ],
            font_names: '宋体;黑体;仿宋_GB2312;微软雅黑;Arial;Times New Roman',
            fontSize_sizes: '一号/26pt;小一/24pt;二号/22pt;小二/18pt;三号/16pt;小三/15pt;四号/14pt;小四/12pt;五号/10.5pt;小五/9pt;六号/7.5pt;小六/6.5pt',
        });
    });

    $(function () {
        $("#addNewsForm").submit(function () {
            $.post("/water/news/addNews",$("#addNewsForm").serialize(),function (data) {
                if (data.flag){
                    alert(data.data);
                    $.post("/water/page/news",{},function (data) {
                        var list = $("#list");
                        list.html(data);
                        list.addClass("detailwindow");
                    })
                }else {
                    alert(data.data);
                    addUser();
                }
            });
            location.href="page/index";
            userManager();
        })
    });
    function addNews() {
        $.get("/water/page/addnews", {}, function (data) {
            var list = $("#list");
            list.html(data);
            list.addClass("detailwindow");
        })
    }

    function newsManager() {
        $.post("/water/page/news", {}, function (data) {
            var list = $("#list");
            list.html(data);
            list.addClass("detailwindow");
        })
    }
</script>
<div class="row title">
    <p>新闻通知管理 &gt; 新建</p>
</div>
<div class="row add-detail">
    <form class="form-horizontal" id="addNewsForm">
        <input type="hidden" value="${sessionScope.loginUser.uId}" name="newsUploadUId">
        <div class="form-group">
            <label for="newsTitle" class="col-sm-2 control-label">标题</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="newsTitle" name="newsTitle">
            </div>
        </div>
        <div class="form-group">
            <label for="newsImg" class="col-sm-2 control-label">图片</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="newsImg" name="newsImg">
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">类别</label>
            <div class="radio col-sm-10">
                <label class="radio-inline">
                    <input type="radio" name="newsCategory" id="radio1" value="1"> 新闻
                </label>
                <label class="radio-inline">
                    <input type="radio" name="newsCategory" id="radio2" value="2"> 通知
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="newsSummary" class="col-sm-2 control-label">摘要</label>
            <div class="col-sm-10">
                <textarea class="form-control" rows="3" cols="20" id="newsSummary" name="newsSummary"
                          style="margin: 0px 713.111px 0px 0px; width: 507px; height: 100px;"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-8" style="text-align: center;margin-left: 15%">
                <textarea id="newsText" name="newsText" style="width:1012px;height: 250px"></textarea>
            </div>

        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">发布</button>
                <button type="button" class="btn btn-primary" onclick="newsManager()">返回</button>
            </div>
        </div>
    </form>
</div>



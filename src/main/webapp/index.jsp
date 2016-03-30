<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="jslib/jquery-easyui-1.4.4/jquery.min.js"></script>
    <script type="text/javascript" src="jslib/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jslib/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>

    <link rel="stylesheet" href="jslib/jquery-easyui-1.4.4/themes/default/easyui.css" type="text/css">
    <link rel="stylesheet" href="jslib/jquery-easyui-1.4.4/themes/icon.css" type="text/css">

    <script>
        function addTab(opts) {
            var t = $('#index_tabs');
            if (t.tabs('exists', opts.title)) {
                t.tabs('select', opts.title);
            } else {
                t.tabs('add', opts);
            }
        }
    </script>
</head>
<body class="easyui-layout">
<div data-options="region:'north'" style="height:100px;">
    <div class="easyui-panel" data-options="title:'顶栏',border:false,fit:true"></div>
</div>
<div data-options="region:'south'" style="height:100px;">
    <div class="easyui-panel" data-options="title:'底栏',border:false,fit:true"></div>
</div>
<div data-options="region:'west'" style="width:200px;">
    <div class="easyui-panel" data-options="title:'功能导航',border:false,fit:true">
        <ul class="easyui-tree" id="tab-title" data-options="onClick:function(node){
                        var url;
                        switch(node.text){
                            case '用户统计' : url = 'tabs/yhtj.html';break;
                            case '用户心情排行' : url = 'tabs/mood.html';break;
                            case '用户活跃地区排行' : url = 'tabs/area.html';break;
                        }
                        addTab({title:node.text,href:url,closable:true});
         }">
            <li>
                <span>首页</span>
            </li>
            <li>
                <span>用户统计</span>
            </li>
            <li>
                <span>用户心情排行</span>
            </li>
            <li>
                <span>用户活跃地区排行</span>
            </li>
        </ul>
    </div>
</div>
<div data-options="region:'center'">
    <div id="index_tabs" class="easyui-tabs" data-options="fit:true,border:false">
        <div title="首页" data-options="closable:false" style="padding:20px;display:block; "></div>
    </div>
</div>
<jsp:include page="admin/login.jsp"/>
</body>
</html>

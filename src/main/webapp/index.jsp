<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <script type="text/javascript" src="jslib/jquery-easyui-1.4.4/jquery.min.js"></script>
    <script type="text/javascript" src="jslib/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="jslib/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>

    <link rel="stylesheet" href="jslib/jquery-easyui-1.4.4/themes/default/easyui.css" type="text/css">
    <link rel="stylesheet" href="jslib/jquery-easyui-1.4.4/themes/icon.css" type="text/css">

    <script>
        $(function () {
            $('#manager_login_loginForm').form({
                url: '${pageContext.request.contextPath}/managerAction!login.action',
                success: function (data) {
                    var obj = jQuery.parseJSON(data);
                    if (obj.success) {
                        $('#manager_login_loginDialog').dialog('close');
                    }
                    $.messager.show({
                        title: '提示',
                        msg: obj.message,
                        showType: 'show'
                    });
                }
            });
            $('#manager_login_loginForm input').bind('keyup', function (event) {
                if (event.keyCode == '13') {
                    $('#manager_login_loginForm').submit();
                }
            });
        });
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
                        addTab({title:node.text,closable:true});

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
        <div title="首页" data-options="closable:true" style="padding:20px;display:block; ">
            <a>首页</a>
        </div>
    </div>
</div>
<div id="manager_login_loginDialog" class="easyui-dialog" style="width:300px;height:150px;" data-options="title:'登录',closable:false,
              buttons:[{
				text:'登录',
				iconCls:'icon-help',
				handler:function(){
				    $('#manager_login_loginForm').submit();
				}
			}]">
    <form method="post" id="manager_login_loginForm">
        <table>
            <tr>
                <th>登录名</th>
                <td><input name="managerName" autofocus class="easyui-validatebox" type="text"
                           data-options="required:true,missingMessage:'登陆名必填'"/></td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input name="managerPassword" class="easyui-validatebox" type="password"
                           data-options="required:true,missingMessage:'密码必填'"/></td>
            </tr>
        </table>
    </form>
</div>
<%--<s:form action="managerLogin" method="POST" namespace="/">
    <s:textfield name="manager.managerName"  label="绠＄悊鍛樼敤鎴峰悕"/>
    <s:textfield name="manager.managerPassword" label="绠＄悊鍛樺瘑鐮�"/>
    <s:submit value="鐧诲綍"/>
</s:form>--%>
</body>
</html>

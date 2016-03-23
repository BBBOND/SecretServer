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
                        alert("success");
                    }
                    $.messager.show({
                        title: '提示',
                        msg: obj.msg,
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
        <div class="easyui-panel" style="padding:5px" data-options="fit:true,border:false">
            <ul class="easyui-tree">
                <li>
                    <span onclick="alert($(this).innerHTML);">首页</span>
                </li>
                <li>
                    <span>用户统计</span>
                </li>
                <li>
                    <span>用户活跃度排行</span>
                </li>
                <li>
                    <span>用户心情排行</span>
                </li>
            </ul>
        </div>
    </div>

</div>

<div data-options="region:'center'">
    <div id="index_centertab" class="easyui-tabs" data-options="fit:true,border:false">
        <div title="首页" class="sub-con cur-sub-con" style="padding:20px;display:none;">
            <a title="首页">首页</a>
        </div>
        <div title="用户统计" class="sub-con" style="padding:20px;display:none;">
            <a title="用户统计">用户统计</a>
        </div>
        <div title="用户心情排行" style="padding:20px;display:none;">
            <a title="用户心情排行">用户心情排行</a>
        </div>
        <div title="用户活跃度排行" style="padding:20px;display:none;">
            <a title="用户活跃度排行">用户活跃度排行</a>
        </div>
    </div>
</div>
<script>

</script>
<div class="easyui-dialog" style="width:300px;height:150px;" data-options="title:'登录',modal:true,
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
                <td><input name="managerName" class="easyui-validatebox" type="text"
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

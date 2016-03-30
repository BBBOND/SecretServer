<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
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
    </script>
</head>
<body>
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
</body>
</html>
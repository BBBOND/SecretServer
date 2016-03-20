<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<h2>Hello World!</h2>

<s:form action="managerLogin" method="POST" namespace="/">
    <s:textfield name="manager.managerName"  label="管理员用户名"/>
    <s:textfield name="manager.managerPassword" label="管理员密码"/>
    <s:submit value="登录"/>
</s:form>
<s:form action="managerselect" method="POST" namespace="/">
  <%--  <s:textfield name="manager.managerName"  label="管理员用户名"/>
    <s:textfield name="manager.managerPassword" label="管理员密码"/>--%>
    <s:submit value="登录"/>
</s:form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<jsp:useBean id="oriCustomer" type="entity.Customer" scope="request"></jsp:useBean>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        您要修改的客户账号信息如下
    </h1>

    <form action="/basicSetting/CustomerAccountModify.do" method="post">
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户ID</label>
            <input type="text" class="mdui-textfield-input" disabled size="10" name="userID"
                   value=
                   <jsp:getProperty name="oriCustomer" property="userID"></jsp:getProperty>
            >
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户账号名</label>
            <input type="text" class="mdui-textfield-input" size="10" name="username"
                   value=
                   <jsp:getProperty name="oriCustomer" property="username"></jsp:getProperty>
            >
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户密码</label>
            <input type="text" class="mdui-textfield-input" size="10" name="password"
                   value=
                   <jsp:getProperty name="oriCustomer" property="password"></jsp:getProperty>
            >
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户姓名</label>
            <input type="text" class="mdui-textfield-input" size="10" name="customerName"
                   value=
                   <jsp:getProperty name="oriCustomer" property="customerName"></jsp:getProperty>
            >
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户身份证</label>
            <input type="text" class="mdui-textfield-input" size="10" name="IDNumber"
                   value=
                   <jsp:getProperty name="oriCustomer" property="IDNumber"></jsp:getProperty>
            >
        </div>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">修改信息</button>
    </form>
</div>


</div>


</div>
<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("AccountSetting");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("CustomerSetting");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>
</body></html>





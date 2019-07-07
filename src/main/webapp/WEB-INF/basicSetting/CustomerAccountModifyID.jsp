<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="DAO.CustomerDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<%
    CustomerDAO customerDAO = new CustomerDAO();
    ArrayList<String> arrayList = customerDAO.getAllCustomersID();
    request.setAttribute("AllRoomID", arrayList);
%>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        请选择要设置的客户账号ID
    </h1>

    <form action="/basicSetting/CustomerAccountModifyID.do" method="post">
        客户账户ID:
        <select class="mdui-select" id="roomTypeSelect" name="queryRoomID">
            <c:forEach var="roomID" items="${requestScope.AllRoomID}"
                       varStatus="status">
                <option>${roomID}</option>
            </c:forEach>
        </select>

        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>
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





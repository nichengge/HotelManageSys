<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="DrawerBar.html" %>

<div class="mdui-container main-container mdui-text-left">
    <h1>
        请输入要换房的相关信息
    </h1>
    <form action="/ReceptionManagement/RoomChange.do" method="post">
        订单ID：
        <select class="mdui-select" name="orderIDChangeRoom">
            <c:forEach var="ordersID" items="${sessionScope.AllOrdersID}"
                       varStatus="status">
                <option>${ordersID}</option>
            </c:forEach>
        </select>
        <br>
        新的房间ID:
        <select class="mdui-select" name="roomChangeOfRoomID">
            <c:forEach var="roomID" items="${sessionScope.AllRoomID}"
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
    var p = document.getElementById("ReceptionManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("RoomChange");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>

</body></html>


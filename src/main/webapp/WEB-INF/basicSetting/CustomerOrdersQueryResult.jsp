<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%--Context--%>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        您要查询的订单情况如下：
    </h1>
    <p>

    </p>

    <div class="mdui-table-fluid">
        <table class="mdui-table mdui-table-hoverable">
            <thead>
            <tr>
                <th>订单ID</th>
                <th>房间ID</th>
                <th>客户ID</th>
                <th>客户名</th>
                <th>订单开始日期</th>
                <th>订单结束日期</th>
                <th>订单状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="orders" items="${requestScope.CustomerOrdersQueryResult}"
                       varStatus="status">
                <tr>
                    <td>${orders.orderID}</td>
                    <td>${orders.roomID}</td>
                    <td>${orders.customerID}</td>
                    <td>${orders.customerName}</td>
                    <td>${orders.dateBegin}</td>
                    <td>${orders.dateEnd}</td>
                    <td>${orders.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</div>

<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("RoomPreservationManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("BookManagement");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>

</body></html>


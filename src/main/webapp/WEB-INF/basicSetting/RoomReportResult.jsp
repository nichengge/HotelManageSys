<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        房间信息如下
    </h1>
    <div class="mdui-table-fluid">
        <table class="mdui-table mdui-table-hoverable">
            <thead>
            <tr>
                <th>房间ID</th>
                <th>房间号</th>
                <th>房间类型</th>
                <th>房间楼层</th>
                <th>房间方位</th>
                <th>房间描述</th>
                <th>房间状态</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="room" items="${sessionScope.roomQueryResultByType}"
                       varStatus="status">
                <tr>
                    <td>${room.ID}</td>
                    <td>${room.number}</td>
                    <td>${room.type}</td>
                    <td>${room.floor}</td>
                    <td>${room.direction}</td>
                    <td>${room.description}</td>
                    <td>${room.status}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<script src="../../static/MDUI_files/mdui.min.js"></script>
<script type="text/javascript">
    //p for parent bar
    var p = document.getElementById("RoomManagement");
    var open = "mdui-collapse-item mdui-collapse-item-open";
    p.setAttribute("class", open);
    //c for child bar
    var c = document.getElementById("RoomReport");
    var active = "mdui-list-item mdui-ripple mdui-list-item-active";
    c.setAttribute('class', active);
</script>
</body></html>


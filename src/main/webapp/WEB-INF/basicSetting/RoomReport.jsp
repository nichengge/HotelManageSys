<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>
<div class="mdui-container main-container mdui-text-left">
    <h1>
        查询
    </h1>
    <form action="/basicSetting/RoomReportQueryByType.do" method="post">
        查询类型:
        <select class="mdui-select" id="roomTypeSelect" name="roomTypeOfQuerying">
            <c:forEach var="RoomType" items="${sessionScope.AllRoomType}"
                       varStatus="status">
                <option>${RoomType}</option>
            </c:forEach>
        </select>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">提交</button>
    </form>
    <br>
    <h1>
        统计
    </h1>


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


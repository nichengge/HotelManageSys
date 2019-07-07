<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<%@include file="DrawerBar.html" %>


<div class="mdui-container main-container mdui-text-left">
    <h1>
        您要修改的订单信息如下：
    </h1>
    <div class="mdui-table-fluid">
        <table class="mdui-table mdui-table-hoverable">
            <jsp:useBean id="queryOrder" type="entity.Orders" scope="request"></jsp:useBean>
            <tbody>
            <tr>
                <th>订单ID</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="orderID"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>房间ID</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="roomID"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>客户ID</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="customerID"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>客户姓名</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="customerName"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>入住日期</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="dateBegin"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>结束日期</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="dateEnd"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>房间类型</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="type"></jsp:getProperty>
                </th>
            </tr>
            <tr>
                <th>订单状态</th>
                <th>
                    <jsp:getProperty name="queryOrder" property="status"></jsp:getProperty>
                </th>
            </tr>
            </tbody>
        </table>
    </div>
    <br>
    <h1>
        将房间信息修改为如下
    </h1>
    <form action="/basicSetting/CustomerOrdersModify.do" method="post">
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">订单ID</label>
            <input class="mdui-textfield-input" type="text" name="orderID"
                   value=<jsp:getProperty name="queryOrder" property="orderID"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">房间ID</label>
            <input class="mdui-textfield-input" type="text" name="roomID"
                   value=<jsp:getProperty name="queryOrder" property="roomID"></jsp:getProperty>>
        </div>

        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户ID</label>
            <input class="mdui-textfield-input" type="text" name="customerID"
                   value=<jsp:getProperty name="queryOrder" property="customerID"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">客户姓名</label>
            <input class="mdui-textfield-input" type="text" name="customerName"
                   value=<jsp:getProperty name="queryOrder" property="customerName"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">入住日期</label>
            <input class="mdui-textfield-input" type="text" name="dateBegin"
                   value=<jsp:getProperty name="queryOrder" property="dateBegin"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">结束日期</label>
            <input class="mdui-textfield-input" type="text" name="dateEnd"
                   value=<jsp:getProperty name="queryOrder" property="dateEnd"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">房间类型</label>
            <input class="mdui-textfield-input" type="text" name="roomType"
                   value=<jsp:getProperty name="queryOrder" property="type"></jsp:getProperty>>
        </div>
        <div class="mdui-textfield mdui-textfield-floating-label">
            <label class="mdui-textfield-label">订单状态</label>
            <input class="mdui-textfield-input" type="text" name="orderStatus"
                   value=<jsp:getProperty name="queryOrder" property="status"></jsp:getProperty>>
        </div>
        <br>
        <button type="submit" class="mdui-btn mdui-btn-raised mdui-ripple mdui-color-theme-accent">修改信息</button>
    </form>

    <br>
    <br>
    <br>
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


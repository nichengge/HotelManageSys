package demo.Controller.ReceptionManagement;

import demo.Controller.BaseController;
import demo.Model.Room;
import demo.Model.TempModel.Bill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller("RoomInformationUpdate")
public class RoomInfomationUpdate extends BaseController {

    @RequestMapping("basicSetting/RoomInformationUpdate")
    public ModelAndView RoomInfoUpdate(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        Room room = (Room) session.getAttribute("resultRoomOfSetting");
        String roomID = String.valueOf(room.getRoom_id());
        String roomType = request.getParameter("roomType");
        String roomFloor = request.getParameter("roomFloor");
        String roomDirection = request.getParameter("roomDirection");
        String roomDescription = request.getParameter("roomDescription");
        String roomStatus = request.getParameter("roomStatus");

        room.setRoom_type(roomType);
        room.setRoom_floor(roomFloor);
        room.setRoom_direction(roomDirection);
        room.setRoom_description(roomDescription);
        room.setRoom_status(roomStatus);
        ans = roomService.updateRoomInformation(room);
        if (ans == 1) {
            message = "房间信息更新成功! 3秒后返回客房信息设置页.";
        } else {
            message = "房间信息更新失败! 请重试! 3秒后返回客房信息设置页.";
        }
        nextURL = "basicSetting/RoomInformationSettingID";
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }


    //退房    Checkout.do
    @RequestMapping("EmployeeDoCheckout")
    public ModelAndView CheckOut(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("checkoutRoomID") Integer roomId) {
        HttpSession session = request.getSession();
        System.out.println(roomId);
        Bill bill = employeeService.getBillByRoomId(String.valueOf(roomId));
        if (bill != null) {
            //可能存在问题
            int orderId = bill.getOrderID();
            ans = (employeeService.roomCheckOut(roomId) == 1) && (ordersService.updateOrderInformationByOrderID(orderId) == 1
                    && (ordersService.calculateBillByOrderID(orderId) == 1)) ? 1 : 0;
            session.setAttribute("checkoutBill", bill);
        }
        if (ans == 1) {
            message = "退房成功！ 3秒后显示账单。";
            nextURL = "receptionManagement/CheckoutShowBill";
        } else {
            message = "退房失败！ 请重试！ 3秒后回到退房界面。";
            nextURL = "receptionManagement/Checkout";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

}

package demo.Controller.basicSetting;

import demo.Controller.BaseController;
import demo.Model.Orders;
import demo.Model.TempModel.CustomerReport;
import demo.Util.DateTransform;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CustomerOrderController extends BaseController {


    //basicSetting/CustomerOrdersModify.do
    @RequestMapping("basicSetting/CustomerOrdersModify")
    public ModelAndView adminCustomerOrdersModify(HttpServletRequest request, HttpServletResponse response,
                                                  @RequestParam("orderID") String orderId,
                                                  @RequestParam("roomID") String roomID,
                                                  @RequestParam("customerID") String customerID,
                                                  @RequestParam("customerName") String customerName,
                                                  @RequestParam("dateBegin") String dateBegin,
                                                  @RequestParam("dateEnd") String dateEnd,
                                                  @RequestParam("roomType") String roomType,
                                                  @RequestParam("orderStatus") String orderStatus) {
        ans = 0;
        Orders orders = new Orders(Integer.valueOf(orderId), roomID, customerID
                , customerName, DateTransform.String2Date(dateBegin),
                DateTransform.String2Date(dateEnd), roomType, orderStatus);
        ans = ordersService.updateOrderById(orders);
        if (ans == 1) {
            message = "订单信息修改成功！ 3秒后重新返回订单管理界面。";
            nextURL = "basicSetting/BookManagement";
        } else {
            message = "订单信息修改失败！ 请重试！ 3秒后重新返回订单修改界面。";
            nextURL = "basicSetting/CustomerOrdersModify";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //basicSetting/CustomerOrdersModifyID.do
    @RequestMapping("basicSetting/CustomerOrdersModifyID")
    public ModelAndView adminCustomerOrdersModifyID(HttpServletRequest request, HttpServletResponse response,
                                                    @RequestParam("IDOfOrderRoomModify") String id) {
        Orders queryOrder = ordersService.queryByOrderId(Integer.valueOf(id));
        request.setAttribute("queryOrder", queryOrder);
        return dispatcher.goPage2(mv, request, response, "basicSetting/CustomerOrdersModifyResult");
    }

    //客户订单查询
    //basicSetting/CustomerOrdersQuery.do
    @RequestMapping("basicSetting/CustomerOrdersQuery")
    public ModelAndView adminCustomerOrdersQuery(HttpServletRequest request, HttpServletResponse response,
                                                 @RequestParam("IDOfCustomerRoomQuery") String id) {
        HttpSession session = request.getSession();
        ans = 0;
        ArrayList<Orders> ordersArrayList = ordersService.queryByCustomerName(id); //存储的是用户名而非id
        if (ordersArrayList != null) {
            System.out.println("orderArryList is not null");
            ans = 1;
            request.setAttribute("CustomerOrdersQueryResult", ordersArrayList);
        }

        if (ans == 1) {
            return dispatcher.goPage2(mv, request, response, "basicSetting/CustomerOrdersQueryResult");
        } else {
            message = "没有该客户订单的相关信息。3秒后返回订单查询界面。";
            nextURL = "basicSetting/CustomerOrdersQuery";
            return dispatcher.goPage(request, response, mv, nextURL, message);
        }
    }

    //basicSetting/ReportOfLivingCustomer.do
    @RequestMapping("basicSetting/ReportOfLivingCustomer")
    public ModelAndView ReportOfLivingCustomer(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<CustomerReport> customerReportArrayList = customerService.getCustomerReport();
        request.setAttribute("customerReportArrayList", customerReportArrayList);
        return dispatcher.goPage2(mv, request, response, "basicSetting/ReportOfLivingCustomer");
    }


    //bookOnline/RoomQueryResultChosen.do
    @RequestMapping("bookOnline/RoomQueryResultChosen")
    public ModelAndView RoomQueryResultChosen(HttpServletRequest request, HttpServletResponse response,
                                              @RequestParam("booked") String chosedRoomType) {
        HttpSession session = request.getSession();
        HashMap<String, Integer> AvailableQueryResult = (HashMap<String, Integer>) session.getAttribute("AvailableQueryResult");
        ans = AvailableQueryResult.get(chosedRoomType);
        if (ans == 0) {
            message = "该房间类型已售空，请选择其他类型的房间，3秒后返回可用房间查询界面。";
            nextURL = "bookOnline/RoomQuery";
            return dispatcher.goPage(request, response, mv, nextURL, message);
        } else {
            HashMap<String, Double> typeAndPrice = roomcategoryService.getTypeAndPrice();
            for (Map.Entry<String, Double> entry : typeAndPrice.entrySet()) {
                if (entry.getKey().equals(chosedRoomType)) {
                    session.setAttribute("type", entry.getKey());
                    session.setAttribute("price", entry.getValue());
                }
            }
            return dispatcher.goPage2(mv, request, response, "bookOnline/BookRoom");
        }
    }
}

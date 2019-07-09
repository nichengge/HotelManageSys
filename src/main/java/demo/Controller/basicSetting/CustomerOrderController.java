package demo.Controller.basicSetting;

import demo.Controller.BaseController;
import demo.Model.Orders;
import demo.Util.DateTransform;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        if(ans==1){
            message = "订单信息修改成功！ 3秒后重新返回订单管理界面。";
            nextURL = "basicSetting/BookManagement";
        }else {
            message = "订单信息修改失败！ 请重试！ 3秒后重新返回订单修改界面。";
            nextURL = "basicSetting/CustomerOrdersModify";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);


    }
}

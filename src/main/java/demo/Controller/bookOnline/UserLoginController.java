package demo.Controller.bookOnline;

import demo.Controller.BaseController;
import demo.Model.Customer;
import demo.Model.Hotel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class UserLoginController extends BaseController {

    @RequestMapping("nameCustomerLogin")
    public ModelAndView userlogin(HttpServletRequest request, HttpServletResponse response, @RequestParam("nameCustomerLogin") String usernmae, @RequestParam("passwordCustomerLogin") String password) {
        System.out.println("用户正在登录");
        HttpSession session = request.getSession();

        Customer customer = new Customer();
        customer.setUsername(usernmae);
        customer.setPassword(password);
        ans = customerService.customerconfirm(customer);

        if (ans == 1) {
            System.out.println("用户登录成功");
            nextURL = "bookOnline/Index";
            message = "Aha O(∩_∩)O 登录成功!  欢迎您!   即将为你跳转至主页";
            Hotel hotel = hotelService.getHotel();
            if (hotel != null) {
                session.setAttribute("locationinfo", hotel.getLocation_info());
                session.setAttribute("trafficinfo", hotel.getTraffic_Info());
                session.setAttribute("hotelname", hotel.getHotel_name());
                session.setAttribute("introdution", hotel.getIntroduction());
            }

        } else {
            System.out.println("用户登录失败");
            nextURL = "/CustomerLogin";
            message = "Oops (T_T) 登录失败!   账号或密码错误!   3秒后跳转回登录界面";
        }

        request.setAttribute("nextURL", nextURL);
        request.setAttribute("intermediateTimer", 3);
        request.setAttribute("message", message);
        mv.addObject("request", request);
        mv.addObject("response", response);
        mv.setViewName("General/intermediatePage");
        System.out.println("页面跳转");

        return mv;
    }
}

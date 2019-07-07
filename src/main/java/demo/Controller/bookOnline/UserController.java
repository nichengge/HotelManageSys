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
public class UserController extends BaseController {

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

        return mv;
    }


    //用户注册
    @RequestMapping("/userRegister")
    public ModelAndView newuser(HttpServletRequest request,HttpServletResponse response,
                            @RequestParam("username") String username,@RequestParam("password") String password,
                            @RequestParam("idcard") String idcard,@RequestParam("realname") String realname,@RequestParam("phone") String phone){
        Customer customer = new Customer(username,password,realname,phone,idcard);
        ans = customerService.addCustomer(customer);

        if(ans==1){
            message = "帐号创建成功O(∩_∩)O！3秒后跳转到登录页面";
            nextURL = "CustomerLogin";
        }
        else {
            message = "Oops~账号创建失败(T_T)！3秒后返回到账号添加界面";
            nextURL = "basicSetting/CustomerAccountAdd";
        }

        request.setAttribute("nextURL", nextURL);
        request.setAttribute("intermediateTimer", 3);
        request.setAttribute("message", message);
        mv.addObject("request", request);
        mv.addObject("response", response);
        mv.setViewName("General/intermediatePage");
        return mv;
    }
}

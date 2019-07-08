package demo.Controller.basicSetting;

import demo.Controller.BaseController;
import demo.Model.Administrator;
import demo.ServerImpl.Helper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ManagerController extends BaseController {
    //用户认证登录
    @RequestMapping("/adminlogin")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String usernmae, @RequestParam("password") String password) {
        HttpSession session = request.getSession();
        Administrator administrator = new Administrator(usernmae, password);
        System.out.println("经理登录验证中");
        ans = administratorService.adminlogin(administrator);
        if (ans == 1) {
            message = "Aha O(∩_∩)O  经理账号登录成功！ 即将为您跳转至经理管理界面！";
            nextURL = "basicSetting/Index";
            //对一些会话期间的参数进行初始化
            Helper helper = new Helper(customerService,ordersService,roomService,employeeService,roomcategoryService);
            helper.loginInitializatjion(request); //此处易报错
        } else {
            message = "Oops (T_T)  经理账号登录失败！ 即将为您跳转回登录界面！";
            nextURL = "/ManagerLogin";
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

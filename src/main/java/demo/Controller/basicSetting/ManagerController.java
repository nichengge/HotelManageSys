package demo.Controller.basicSetting;

import demo.Controller.BaseController;
import demo.Model.Administrator;
import demo.Model.Customer;
import demo.ServerImpl.Helper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ManagerController extends BaseController {
    //用户认证登录
    @RequestMapping("/adminlogin")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password) {
        Administrator administrator = new Administrator(username, password);
        System.out.println("经理登录验证中");
        ans = administratorService.adminlogin(administrator);
        if (ans == 1) {
            message = "Aha O(∩_∩)O  经理账号登录成功！ 即将为您跳转至经理管理界面！";
            nextURL = "basicSetting/Index";
            //对一些会话期间的参数进行初始化
            Helper helper = new Helper(customerService, ordersService, roomService, employeeService, roomcategoryService);
            helper.loginInitializatjion(request);
        } else {
            message = "Oops (T_T)  经理账号登录失败！ 即将为您跳转回登录界面！";
            nextURL = "/ManagerLogin";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //客户管理
    //增加客户
    @RequestMapping("adminAddUser")
    public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam("customerUsernameAdd") String username,
                                @RequestParam("customerPasswordAdd") String password,
                                @RequestParam("customerIDNumberAdd") String idcard,
                                @RequestParam("customerNameAdd") String realname,
                                @RequestParam("customerPhoneAdd") String phone) {
        Customer customer = new Customer(username, password, realname, phone, idcard);
        ans = customerService.addCustomer(customer);
        if (ans == 1) {
            message = "操作成功！3秒后跳转到客户账号管理界面。";
            nextURL = "basicSetting/CustomerSetting";
        } else {
            message = "操作失败！3秒后返回到客户账号添加界面。";
            nextURL = "basicSetting/CustomerAccountAdd";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //删除客户
    @RequestMapping("adminDelUser")
    public ModelAndView deleUser(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("deleteCusotmerID") String customerId) {
        System.out.println(customerId);
        //执行删除操作
        ans = customerService.delUserById(Integer.parseInt(customerId));
        if (ans == 1) {
            message = "删除操作成功!3秒后返回客户账号管理界面。";
            nextURL = "basicSetting/CustomerSetting";
        } else {
            message = "删除操作失败! 无对应的客户账号ID! 请重试!";
            nextURL = "basicSetting/CustomerAccountDelete";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //账户修改1
    @RequestMapping("CustomerAccountModifyID")
    public ModelAndView adminUpdateCustomer(HttpServletRequest request, HttpServletResponse response,
                                            @RequestParam("userIDModify") String customer_id) {
        Customer customer = customerService.queryByUserID(Integer.valueOf(customer_id));
        if (customer != null) {
            ans = 1;
            request.setAttribute("oriCustomer", customer);
        } else {
            ans = 0;
        }
        if (ans == 1) {
            mv.setViewName("basicSetting/CustomerAccountModify");
            return mv;
        } else {
            nextURL = "/basicSetting/CustomerAccountModifyID";
            message = "无改ID的客户的相关信息，请重新查询！";
            mv.setViewName("General/intermediatePage");
            return dispatcher.goPage(request, response, mv, nextURL, message);
        }
    }


    //账户修改2
    @PostMapping("adminUpdateUser")
    public ModelAndView UpdateUser(HttpServletRequest request, HttpServletResponse response,
                                   @RequestParam("userId")Integer customerId,
                                   @RequestParam("userName") String username,
                                   @RequestParam("Password") String password,
                                   @RequestParam("Idcard") String idcard,
                                   @RequestParam("RealName") String realname,
                                   @RequestParam("UserPhone") String phone) {
        Customer customer = new Customer(customerId, username, password, phone, idcard, realname);
        ans = customerService.updateUser(customer);
        System.out.println("正在修改用户信息...from ManagerController");
        if (ans == 1) {
            message = "修改操作成功!3秒后返回客户账号管理界面。";
            nextURL = "basicSetting/CustomerSetting";
        } else {
            message = "修改操作失败 ! 请重试!";
            nextURL = "basicSetting/CustomerAccountModify";
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

}

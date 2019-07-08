package demo.Controller.ReceptionManagement;

import demo.Controller.BaseController;
import demo.Model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class EmployeeController extends BaseController {

    @RequestMapping("employeelogin")
    public ModelAndView employeelogin(HttpServletRequest request, HttpServletResponse response, @RequestParam("receptionistName") String usernmae, @RequestParam("receptionistPassword") String password){
        System.out.println("雇员正在登录");
        HttpSession session = request.getSession();
        Employee employee = new Employee(usernmae,password);
        ans=employeeService.employeeconfirm(employee);
        if(ans==1){
            System.out.println("接待员登录成功");
            message = "AHa 欢迎您! 接待员账号登录成功(●'◡'●)! 即将为您跳转至接待员管理界面.";
            nextURL = "receptionManagement/Index";
        }
        else{
            System.out.println("接待员登录失败");
            message = "Oops 接待员账号或密码错误(T_T)!  3秒后跳转至接待员登录界面!";
            nextURL = "/ReceptionistLogin";
        }


        request.setAttribute("nextURL", nextURL);
        request.setAttribute("intermediateTimer", 3);
        request.setAttribute("message", message);
        mv.addObject("request",request);
        mv.addObject("response",response);
        mv.setViewName("General/intermediatePage");
        return mv;
    }

}

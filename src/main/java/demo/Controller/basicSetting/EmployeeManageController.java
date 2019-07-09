package demo.Controller.basicSetting;

import demo.Controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author YZQ
 *
 * @DATE 2019/7/9 0:31
 */
@Controller
public class EmployeeManageController extends BaseController {

    @RequestMapping("employeeAccountModify")
    public ModelAndView employeeAccountModify(HttpServletRequest request, HttpServletResponse response) {


        return dispatcher.goPage(request, response, mv, nextURL, message);
    }
}

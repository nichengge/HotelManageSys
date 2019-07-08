package demo.Util;

import demo.Controller.BaseController;
import demo.Model.Employee;
import demo.Model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestDemo extends BaseController {

    //用于简单功能测试
    @RequestMapping("testdemo")
    public void scrip1(HttpServletRequest request, HttpServletResponse response) {
        Room room = new Room();
        room.setRoom_id(1);
        room.setRoom_number("304");
        roomService.updateRoomInformation(room);
        System.out.println("test");

        Employee employee = employeeService.queryById(10000);
        System.out.println(employee.getEmployee_username());
    }
}

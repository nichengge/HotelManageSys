package demo.ServerImpl;

import demo.Model.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Helper {

    //添加登录用户到会话域
    public static void loginedCustomer(HttpServletRequest request, String customerID) {
        Customer LoginedCustomer;
        CustomerService customerService = new CustomerService();
        LoginedCustomer = customerService.queryByUserID(customerID);
        HttpSession session = request.getSession();
        session.setAttribute("LoginedCustomer", LoginedCustomer);
    }


    //用户会话初始化内容
    public static void loginInitializatjion(HttpServletRequest request) {
        HttpSession session = request.getSession();
        CustomerService customerService = new CustomerService();
        OrdersService ordersService = new OrdersService();
        RoomService roomService = new RoomService();
        EmployeeService employeeService = new EmployeeService();
        RoomcategoryService roomcategoryService = new RoomcategoryService();

        try {
            ArrayList<String> arrayListAllCustomerID = customerService.getAllCustomersID(); //获取所有用户id
            session.setAttribute("AllCustomerID", arrayListAllCustomerID);

            ArrayList<String> arrayListAllOrdersID = ordersService.getAllOrdersID();
            session.setAttribute("AllOrdersID", arrayListAllOrdersID);

            ArrayList<String> arrayListAllRoomID = roomService.getAllRoomID();
            session.setAttribute("AllRoomID", arrayListAllRoomID);

            ArrayList<String> arrayListAllRoomType = roomcategoryService.getAllCategory();
            session.setAttribute("AllRoomType", arrayListAllRoomType);

            ArrayList<String> allemployeeid = employeeService.getAllEmployeesId();
            session.setAttribute("AllReceptionistID", allemployeeid);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    //TODO  需要检测生成的ID是否已经在表中
    public static String getRandomUserID() {
        Random randomGenerator = new Random();
        long n = 0;
        do {
            n = randomGenerator.nextLong();
        } while (n < 0);
        String s = String.valueOf(n);
        return s;
    }
}

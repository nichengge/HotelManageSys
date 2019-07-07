package demo.Controller;

import demo.ServerImpl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


public class BaseController {

    //标记状态
    protected int ans=0;

    //跳转使用
    protected String message, nextURL;


    protected ModelAndView mv = new ModelAndView();
    @Autowired
    protected AdministratorService administratorService = new AdministratorService();
    @Autowired
    protected     CommentService commentService = new CommentService();
    @Autowired
    protected    CustomerService customerService = new CustomerService();
    @Autowired
    protected   EmployeeService employeeService = new EmployeeService();
    @Autowired
    protected  HotelService hotelService = new HotelService();
    @Autowired
    protected  OrdersService ordersService = new OrdersService();
    @Autowired
    protected  QuestionService questionService = new QuestionService();
    @Autowired
    protected  RoomcategoryService roomcategoryService = new RoomcategoryService();
    @Autowired
    protected  RoomService roomService = new RoomService();


}
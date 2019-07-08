package demo.ServerImpl;

import demo.Model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("EmployeeService")
@Transactional
@SuppressWarnings("all")
public class EmployeeService extends BaseService {
    int ans = 0;


    //增

    //删

    //查

    public ArrayList<Integer> getAllEmployeesId() {
        ArrayList<Integer> allemployeeid = null;
        try {
            if (null != employeeMapper.getallemployeeid())
                allemployeeid = employeeMapper.getallemployeeid();
            if (allemployeeid == null) {
                System.out.println("查询失败...from EmployeeService");
            } else {
                System.out.println("查询成功...from EmployeeService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from EmployeeService");
        }
        return allemployeeid;
    }

    //登录验证
    public int employeeconfirm(Employee employee) {
        Employee em = null;
        try {
            em = employeeMapper.employeeconfirm(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (em != null) {
            ans = 1;
        } else {
            ans = 0;
        }
        return ans;
    }

    //改


}

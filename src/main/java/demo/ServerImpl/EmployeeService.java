package demo.ServerImpl;
import demo.Model.Customer;
import demo.Model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("EmployeeService")
@Transactional
@SuppressWarnings("all")
public class EmployeeService extends BaseService{
    int ans=0;



    //增

    //删

    //查

    public ArrayList<String> getAllEmployeesId() {
        ArrayList<String>allemployeeid=null;
        try {
            allemployeeid = employeeMapper.getallemployeeid();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allemployeeid;
    }

    //登录验证
    public int employeeconfirm(Employee employee) {
        Employee em = null;
        try {
            em = employeeMapper.employeeconfirm(employee);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(em!=null){
            ans=1;
        }
        else{
            ans=0;
        }
        return ans;
    }

    //改


}

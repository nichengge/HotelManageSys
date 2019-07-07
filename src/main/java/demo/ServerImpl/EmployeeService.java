package demo.ServerImpl;
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

    //改


}

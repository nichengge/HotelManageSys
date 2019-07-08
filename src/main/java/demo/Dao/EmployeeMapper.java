package demo.Dao;

import demo.Model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
@Service
public interface EmployeeMapper {

    //增
    int insert(Employee record);

    int insertSelective(Employee record);



    //删

    //改

    //查

    Employee employeeconfirm(Employee employee);

    ArrayList<String> getallemployeeid();

    Employee selectById(int i);
}
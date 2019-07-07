package demo.Dao;

import demo.Model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

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
}
package demo.Dao;

import demo.Model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface EmployeeMapper {
    int insert(Employee record);

    int insertSelective(Employee record);
}
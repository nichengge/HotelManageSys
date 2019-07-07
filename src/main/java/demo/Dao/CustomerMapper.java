package demo.Dao;

import demo.Model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface CustomerMapper {
    int insert(Customer record);

    int insertSelective(Customer record);
}
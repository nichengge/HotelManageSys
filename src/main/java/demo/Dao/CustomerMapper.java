package demo.Dao;

import demo.Model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
@Service
public interface CustomerMapper {

    //增

    //增加用户
    int insert(Customer record);

    int insertSelective(Customer record);




    //删

    //改

    //查

    Customer customerconfirm(Customer customer);

    Customer selectByid(String username);

    ArrayList<String> getAllCustomerid();

}
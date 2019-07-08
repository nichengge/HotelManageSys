package demo.Dao;

import demo.Model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
@Service
public interface OrdersMapper {

    //增
    int insert(Orders record);

    int insertSelective(Orders record);




    //删

    //改

    //查
    ArrayList<String> getallordersid();

}
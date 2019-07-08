package demo.Dao;

import demo.Model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Mapper
@Service
public interface OrdersMapper {

    //增
    int insert(Orders record);

    int insertSelective(Orders record);


    //删

    //改

    //续房
    int updateDateEndByOrderID(int orderId, Date newDate);

    //更改订单状态
    int updateStatusByOrderID(int orderId, String status);


    //查
    ArrayList<String> getallordersid();


}
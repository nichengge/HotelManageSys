package demo.Dao;

import demo.Model.Orders;
import demo.Model.TempModel.Bill;
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

    //?更新账单账户?未实现
    int updateOrderAccountByID(int ordreId);


    //查


    ArrayList<String> getallordersid();
    //获取收入
    Bill getBillByRoomId(int roomId);

    //单一变动
    int singleUpdate(String roomId, int newRoomId, String orderId, int orderId1);

    //暂未实现
    int updateRoomIDByOrderID(int orderId, int roomId);
}
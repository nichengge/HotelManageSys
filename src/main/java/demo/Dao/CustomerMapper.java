package demo.Dao;

import demo.Model.Customer;
import demo.Model.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
@Service
public interface CustomerMapper {

    /*
    增加
     */

    //增加用户
    int insert(Customer record);

    int insertSelective(Customer record);


    /*
    删除
     */
    int deleteByUserId(int userId);



    /*
    修改
     */

    //更新用户名
    int updateUsername(int customerid, String username);

    //更新密码
    int updatePassword(int customerid, String password);

    //更新身份证号
    int updateIdcard(int customerid, String idcard);




    /*
    查找
     */

    List<Customer> queryByUsername(String username); //返回List类型

    //获取所有客户对象
    List<Customer> getAllCustomers();

    Customer queryByUserId(int userId);

    Customer customerconfirm(Customer customer);

    Customer selectByid(String username);

    //获取所有客户id
    ArrayList<Integer> getAllCustomersId();

    //查询所有在住客户
    List<Customer> queryCustomersLiving();

    //显示客户订单
    List<Orders> showOrders();

    //显示不可用房间类型号
    HashMap<String,Integer> getUnavailableRoomTypeWithNumber(Date starttime, Date endtime);

}
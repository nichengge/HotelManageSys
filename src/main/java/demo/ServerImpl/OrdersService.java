package demo.ServerImpl;

import demo.Model.Orders;
import demo.Model.TempModel.Bill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Service("OrdersService")
@Transactional
@SuppressWarnings("all")
public class OrdersService extends BaseService {
    int ans = 0;


    //增

    //删

    //查
    public ArrayList<String> getAllOrdersID() {
        ArrayList<String> allordersid = null;
        try {
            if (null != ordersMapper.getallordersid()) //注意这里处理不当会报错，空指针Exception
                allordersid = ordersMapper.getallordersid();
            if (allordersid == null) {
                System.out.println("查询失败...from OrdersService");
            } else {
                System.out.println("查询成功...from OrdersService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from OrdersService");
        }
        return allordersid;
    }


    //计算收入
    public int calculateBillByOrderID(int ordreId) {
        try {
            ans = ordersMapper.updateOrderAccountByID(ordreId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //获取订单
    public Bill getBillByRoomID(String roomId){
        Bill bill = null;
        try {
            bill = ordersMapper.getBillByRoomId(roomId);
        }catch (Exception e){
            e.printStackTrace();
        }

        /*
        ResultSet r = stm.executeQuery();
        Bill bill = new Bill();
        while (r.next()) {
            bill.setCustomerID(r.getString("customerID"));
            bill.setCustomerName(r.getString("customerName"));
            bill.setOrderID(r.getString("OrderID"));
            bill.setID(r.getString("ID"));
            bill.setType(r.getString("type"));
            bill.setFloor(r.getString("floor"));
            bill.setDateBegin(r.getString("dateBegin"));
            bill.setDateEnd(r.getString("dateEnd"));
            bill.setRoomNumber(r.getString("number"));
        }
         */


        return bill;
    }

    //改

    //更新订单信息
    public int updateOrderInformationByOrderID(int orderId) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        //String nowDate = dateFormat.format(date);
        try {
            ans = (ordersMapper.updateDateEndByOrderID(orderId, date) == 1
                    && ordersMapper.updateStatusByOrderID(orderId, "退房") == 1) ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //更新订单房间信息
    public int updateRoomIDByOrderID(int orderId, String roomName) {
        try {
            ans = ordersMapper.updateRoomNameByOrderID(orderId, roomName);
        } catch (Exception e) {
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
        return ans;
    }

    public int updateOrderAccountByID(int orderId) {
        try {
            ResultSet r = ordersMapper.getOrderPrice(orderId);
            while (r.next()) {
                int day = 1;
                double price = r.getDouble("roomcategory_price");
                double account = day * price;
                System.out.println(account);
                ans = ordersMapper.updateOrderAccount(orderId, account);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //换房
    public int changeRoomByOrderID(int orderId, int newRoomId) {
        try {
            ans = ordersMapper.singleUpdate("roomId", String.valueOf(newRoomId), "orderId", String.valueOf(orderId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //续房
    public int extendCheckoutTimeByOrderID(int orderId, Date newDate) {
        try {
            ordersMapper.updateDateEndByOrderID(orderId, newDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }


    //直接根据订单对象更新信息
    public int updateOrderById(Orders orders) {
        try {
            ans  = ordersMapper.updateOrderByID(orders);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ans;
    }
}

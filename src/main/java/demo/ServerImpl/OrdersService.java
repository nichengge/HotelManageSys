package demo.ServerImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //改

    //更新订单信息
    public int updateOrderInformationByOrderID(int orderId) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            //String nowDate = dateFormat.format(date);
            ans = (ordersMapper.updateDateEndByOrderID(orderId, date) == 1
                    && ordersMapper.updateStatusByOrderID(orderId, "退房") == 1) ? 1 : 0;
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


}

package demo.ServerImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("OrdersService")
@Transactional
@SuppressWarnings("all")
public class OrdersService extends BaseService {
    int ans = 0;


    //增

    //删

    //查
    public ArrayList<Integer> getAllOrdersID() {
        ArrayList<Integer> allordersid = null;
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


}

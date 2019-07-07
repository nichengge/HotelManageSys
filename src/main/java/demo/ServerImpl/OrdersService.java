package demo.ServerImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;


@Service("OrdersService")
@Transactional
@SuppressWarnings("all")
public class OrdersService extends BaseService{
    int ans=0;


    //增

    //删

    //查
    public ArrayList<String> getAllOrdersID() {
        ArrayList<String> allordersid = null;
        try {
            allordersid = ordersMapper.getallordersid();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allordersid;
    }

    //改


}

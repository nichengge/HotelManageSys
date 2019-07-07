package demo.ServerImpl;

import demo.Model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("CustomerService")
@Transactional
@SuppressWarnings("all")
public class CustomerService extends BaseService{
    int ans=0;

    //增

    //增加客户
    public int addCustomer(Customer customer){
        try {
            ans = customerMapper.insert(customer);
            if(ans==1){
                System.out.println("用户新建成功");
            }
            else{

            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("用户新建失败");
        }
        return ans;
    }

    //删

    //查

    //用户验证
    public int customerconfirm(Customer customer){
        Customer customer1 = customerMapper.customerconfirm(customer);
        if(customer1!=null){
            ans=1;
        }
        else{
            ans=0;
        }
        return ans;
    }

    //根据用户ID查找
    public Customer queryByUserID(String customerid){
        Customer customer=null;
        try {
            customer = customerMapper.selectByid(customerid);
            if(customer!=null){
                System.out.println("查询成功...from CustomerService");
            }
            else{
                System.out.println("查询失败...from CustomerService");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("查找失败...from CustomerService");
        }
        return customer;
    }

    //获取所有用户的idlist，string类型
    public ArrayList<String> getAllCustomersID(){
        ArrayList<String>allcustomerid=null;
        try {
            allcustomerid = customerMapper.getAllCustomerid();
            if(allcustomerid!=null){
                System.out.println("查询成功...from CustomerService");
            }
            else{
                System.out.println("查询失败...from CustomerService");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("数据库错误...from CustomerService");
        }
        return allcustomerid;

    }



    //改


}

package demo.ServerImpl;

import demo.Model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //改


}

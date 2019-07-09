package demo.ServerImpl;

import demo.Model.Customer;
import demo.Model.TempModel.CustomerReport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Service("CustomerService")
@Transactional
@SuppressWarnings("all")
public class CustomerService extends BaseService {
    int ans = 0;

    //增

    //增加客户
    public int addCustomer(Customer customer) {
        try {
            ans = customerMapper.insert(customer);
            if (ans == 1) {
                System.out.println("用户新建成功");
            } else {

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("用户新建失败");
        }
        return ans;
    }

    //删

    public int delUserById(int customerId) {
        try {
            ans = customerMapper.deleteByUserId(customerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //查

    //用户验证
    public int customerconfirm(Customer customer) {
        Customer customer1 = null;
        try {
            customer1 = customerMapper.customerconfirm(customer);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql错误...from CustomerService");
        }
        if (customer1 != null) {
            ans = 1;
        } else {
            ans = 0;
        }
        return ans;
    }

    //根据用户名查找用户
    public Customer getCustomerByUsernamePassword(String username, String password) {
        Customer customer = null;
        try {
            customer = customerMapper.queryByUsernamePassword(username, password);
            if (customer != null)
                System.out.println("用户获取成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    //根据用户ID查找
    public Customer queryByUserID(int customerid) {
        Customer customer = null;
        try {
            customer = customerMapper.queryByUserId(customerid);
            if (customer != null) {
                System.out.println("查询成功...from CustomerService");
            } else {
                System.out.println("查询失败...from CustomerService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查找失败...from CustomerService");
        }
        return customer;
    }

    //获取所有用户的idlist，string类型
    public ArrayList<String> getAllCustomersID() {
        ArrayList<String> allcustomerid = null;
        try {
            //此处报错；
            if (customerMapper.getAllCustomersId() != null)
                allcustomerid = customerMapper.getAllCustomersId();
            if (allcustomerid == null) {
                System.out.println("查询失败...from CustomerService");
            } else {
                System.out.println("查询成功...from CustomerService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from CustomerService");
        }
        return allcustomerid;

    }

    //获取用户报告
    public ArrayList<CustomerReport> getCustomerReport() {
        ArrayList<CustomerReport> arrayList = new ArrayList<>();
        try {
            ResultSet r = customerMapper.queryCustomersLiving();

            while (r.next()) {
                String userID = r.getString("customer_id");
                String IDNumber = r.getString("id_card");
                String customerName = r.getString("realname");
                String roomID = r.getString("roomn_umber");
                String dateBegin = r.getString("start_time");
                String dateEnd = r.getString("end_time");

                CustomerReport customerReport =
                        new CustomerReport.
                                Builder(Integer.valueOf(userID)).
                                IDNumber(IDNumber).
                                customerName(customerName).
                                roomID(Integer.valueOf(roomID)).
                                startTime(dateBegin).
                                endTime(dateEnd).
                                build();
                arrayList.add(customerReport);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public HashMap<String, Integer> getUnavailableRoom(Date startTime, Date endTime) {
        HashMap<String, Integer> hashMap = null;
        try {
            hashMap = customerMapper.getUnavailableRoomTypeWithNumber(startTime, endTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (hashMap != null)
            System.out.println("查询成功...from CustomerService");
        return hashMap;
    }


    //改

    public int updateUser(Customer customer) {
        try {
            ans = customerMapper.updateUser(customer);
            System.out.println("修改用户信息成功...from CustomerService");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("修改用户信息失败...from CustomerService");
        }
        return ans;
    }


}

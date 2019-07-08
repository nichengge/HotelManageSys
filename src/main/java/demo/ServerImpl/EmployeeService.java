package demo.ServerImpl;

import demo.Model.Employee;
import demo.Model.Room;
import demo.Model.TempModel.Bill;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("EmployeeService")
@Transactional
@SuppressWarnings("all")
public class EmployeeService extends BaseService {
    int ans = 0;

    //包含前台管理

    //增

    //删

    //查

    public ArrayList<String> getAllEmployeesId() {
        ArrayList<String> allemployeeid = null;
        try {
            if (null != employeeMapper.getallemployeeid())
                allemployeeid = employeeMapper.getallemployeeid();
            if (allemployeeid == null) {
                System.out.println("查询失败...from EmployeeService");
            } else {
                System.out.println("查询成功...from EmployeeService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from EmployeeService");
        }
        return allemployeeid;
    }

    //登录验证
    public int employeeconfirm(Employee employee) {
        Employee em = null;
        try {
            em = employeeMapper.employeeconfirm(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (em != null) {
            ans = 1;
        } else {
            ans = 0;
        }
        return ans;
    }

    //根据Id查找员工
    public Employee queryById(int i) {
        Employee employee = null;
        try {
            employee = employeeMapper.selectById(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    //获取薪水信息
    public Bill getBillByRoomId(int roomId) {
        Bill bill = new Bill();
        try {
            bill = ordersMapper.getBillByRoomId(roomId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bill;
    }

    //预定签入查询
    public ArrayList<Room> preservationCheckinRoomQuery(int orderId) {
        ArrayList<Room> arrayList = null;
        try {
            arrayList = roomMapper.getAvailableRoomByOrdersId(orderId);
        } catch (Exception e) {
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
        return arrayList;
    }

    //改

    //房间入住
    public int preservationCheckin(int orderId, String roomId) {
        try {
            ans = (ordersMapper.updateStatusByOrderID(orderId, "在住") == 1 && ordersMapper.updateRoomNameByOrderID(orderId, roomId) == 1) ? 1 : 0;
        } catch (Exception e) {
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
        return ans;
    }


}

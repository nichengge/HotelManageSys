package demo.ServerImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("RoomService")
@Transactional
@SuppressWarnings("all")
public class RoomService extends BaseService {
    int ans = 0;


    //增

    //删

    //查

    //获取所有房间id
    public ArrayList<String> getAllRoomID() {
        ArrayList<String> allroomid = null;
        try {
            if (null != roomMapper.getallroomid())
                allroomid = roomMapper.getallroomid();
            if (allroomid == null) {
                System.out.println("查询失败...from RoomService");
            } else {
                System.out.println("查询成功...from RoomService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from RoomService");
        }
        return allroomid;
    }

    //改


}

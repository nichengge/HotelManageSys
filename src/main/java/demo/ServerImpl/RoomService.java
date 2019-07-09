package demo.ServerImpl;

import demo.Model.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;


@Service("RoomService")
@Transactional
@SuppressWarnings("all")
public class RoomService extends BaseService {
    int ans = 0;

    //基本负责功能的增删查改
    //增****************************************************************

    public int addNewRoom() {
        return 0;
    }

    //删****************************************************************

    //查****************************************************************

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

    //获取所有房间类型
    public HashMap<String, Integer> getAllroomType() {
        HashMap<String, Integer> hashMap = null;
        try {
            hashMap = roomMapper.getAllRoomTypeWithNumber();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("查询失败，数据库错误...from RoomService");
        }
        if (hashMap != null) {
            System.out.println("查询房间信息成功");
        }
        return hashMap;
    }

    //改****************************************************************


    //修改房间信息
    public int updateRoomInformation(Room room) {
        try {
            ans = roomMapper.updateRoomInfo(room);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("房间信息更新失败...from RoomService");
        }
        return ans;
    }

    //退房
    public int roomCheckout(int roomId) {
        try {
            ans = roomMapper.updateStatusByRoomID(roomId, "可用");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //修改房间号
    public int changeRoomNumber(int roomId, String newRoomNumber) {
        try {
            ans = roomMapper.changeRoomNumber(roomId, newRoomNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //更改房间状态为可用
    public int fixDoneByRoomID(int roomId) {
        try {
            ans = roomMapper.updateStatusByRoomID(roomId, "可用");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //更改房间状态为维修中
    public int fixingRoomByRoomID(int roomId) {
        try {
            ans = roomMapper.updateStatusByRoomID(roomId, "维修中");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }


}

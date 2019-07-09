package demo.Dao;

import demo.Model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Mapper
@Service
public interface RoomMapper {

    //增

    //增加新房间
    int insert(Room record);

    int insertSelective(Room record);


    //删
    int deleteRoomById(int roomId);

    int deleteRoomByName(String roomName);

    //改

    //更新房间信息
    int updateRoomInfo(Room room);

    int updateRoomNumberByRoomID(int roomId, String roomNumber);




    int updateStatusByRoomID(int roomId, String status);


    //查

    //按照房间id查找
    Room roomQueryByID(int roomId);

    List<HashMap<String, Integer>> getAllRoomTypeWithNumber();

    //获取所有时间段内不可用房间
    ArrayList<Room> getRoomUnavailableBetween(Date startTime, Date endTime);

    ArrayList<String> getallroomid();

    //获取所有房间类型
    ArrayList<Room> getAllRoomByType(String type);

    //获取可用房间
    ArrayList<Room> getAvailableRoomByOrdersId(int orderId);
}
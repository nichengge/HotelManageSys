package demo.Dao;

import demo.Model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
@Service
public interface RoomMapper {

    //增
    int insert(Room record);

    int insertSelective(Room record);


    //删
    int deleteRoom(int roomId);

    //改

    //更新房间信息
    int updateRoomInfo(Room room);

    //更改房间号
    int changeRoomNumber(int roomId, String roomNumber);

    int updateStatusByRoomID(int roomId, String status);


    //查

    ArrayList<String> getallroomid();

    //获取可用房间
    ArrayList<Room> getAvailableRoomByOrdersId(int orderId);
}
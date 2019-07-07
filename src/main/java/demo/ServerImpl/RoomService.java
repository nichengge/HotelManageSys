package demo.ServerImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("RoomService")
@Transactional
@SuppressWarnings("all")
public class RoomService extends BaseService{
    int ans=0;


    //增

    //删

    //查

    //获取所有房间id
    public ArrayList<String> getAllRoomID() {
        ArrayList<String>allroomid = null;
        try {
            allroomid = roomMapper.getallroomid();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allroomid;
    }

    //改



}

package demo.ServerImpl;

import demo.Model.Roomcategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("RoomcategoryService")
@Transactional
@SuppressWarnings("all")
public class RoomcategoryService extends BaseService {
    int ans = 0;


    //增

    //增加房间类型
    public int addRoomCategory(Roomcategory roomcategory) {
        try {
            ans = roomcategoryMapper.insert(roomcategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //删

    //查
    public ArrayList<String> getAllCategory() {
        ArrayList<String> allcategory = null;
        try {
            if (null != roomcategoryMapper.getallcategoryid())
                allcategory = roomcategoryMapper.getallcategoryid();
            if (allcategory == null) {
                System.out.println("查询失败...from RoomcategoryService");
            } else {
                System.out.println("查询成功...from RoomcategoryService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from RoomcategoryService");
        }
        return allcategory;
    }

    public ArrayList<Roomcategory> getRoomPreservationInitialize() {
        ArrayList<Roomcategory> arrayList = null;
        try {
            arrayList = roomcategoryMapper.getRoomPreservationInitialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    //改


}

package demo.ServerImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;


@Service("RoomcategoryService")
@Transactional
@SuppressWarnings("all")
public class RoomcategoryService extends BaseService{
    int ans=0;


    //增

    //删

    //查
    public ArrayList<String> getAllCategory() {
        ArrayList<String>allcategory = null;
        try {
            allcategory = roomcategoryMapper.getallcategoryid();
        }catch (Exception e){
            e.printStackTrace();
        }
        return allcategory;
    }

    //改


}

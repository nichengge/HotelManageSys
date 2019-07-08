package demo.Dao;

import demo.Model.Roomcategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Mapper
@Service
public interface RoomcategoryMapper {

    //增
    int insert(Roomcategory record);

    int insertSelective(Roomcategory record);



    //删

    //改

    //查

    ArrayList<String> getallcategoryid();

}
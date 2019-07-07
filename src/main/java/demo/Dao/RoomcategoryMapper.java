package demo.Dao;

import demo.Model.Roomcategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface RoomcategoryMapper {

    //增
    int insert(Roomcategory record);

    int insertSelective(Roomcategory record);

    //删

    //改

    //查

}
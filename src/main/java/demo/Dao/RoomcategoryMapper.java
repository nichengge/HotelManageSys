package demo.Dao;

import demo.Model.Roomcategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface RoomcategoryMapper {
    int insert(Roomcategory record);

    int insertSelective(Roomcategory record);
}
package demo.Dao;

import demo.Model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface RoomMapper {

    //增
    int insert(Room record);

    int insertSelective(Room record);


    //删

    //改

    //查



}
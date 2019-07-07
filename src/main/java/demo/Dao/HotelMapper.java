package demo.Dao;

import demo.Model.Hotel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface HotelMapper {
    int insert(Hotel record);

    int insertSelective(Hotel record);
}
package demo.Dao;

import demo.Model.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface AdministratorMapper {

    //增
    int insert(Administrator record);
    int insertSelective(Administrator record);


    //删

    //改

    //查
    Administrator adminconfirm(Administrator record);


}
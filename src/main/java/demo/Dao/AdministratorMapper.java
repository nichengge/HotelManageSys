package demo.Dao;

import demo.Model.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface AdministratorMapper {


    int insert(Administrator record);
    Administrator adminconfirm(Administrator record);

    int insertSelective(Administrator record);
}
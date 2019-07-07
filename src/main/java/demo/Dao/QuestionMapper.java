package demo.Dao;

import demo.Model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface QuestionMapper {
    int insert(Question record);

    int insertSelective(Question record);
}
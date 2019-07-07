package demo.Dao;

import demo.Model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface CommentMapper {
    int insert(Comment record);

    int insertSelective(Comment record);
}
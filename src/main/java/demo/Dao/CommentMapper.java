package demo.Dao;

import demo.Model.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface CommentMapper {

    //增

    //新增评论
    int insert(Comment record);

    int insertSelective(Comment record);




    //删

    //改

    //查


}
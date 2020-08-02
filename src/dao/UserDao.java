package dao;

import entity.ResoultOfUser;
import entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * 只声明，不实现
 */
public interface UserDao {
    //添加用户
    void add(User user);
    //根据email查询用户
    User quarryUser(String email);
    //判断邮箱是否存在
    boolean vertifyEmail(String email);
    //根据用户id更新用户文字信息
    int updateUserMessage(User user);

}

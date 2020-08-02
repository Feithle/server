package dao;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface ImgDao {
    //更新用户头像存储路径
    int updateUserAvatarPath(@Param("user_id") int user_id, @Param("path_avatar") String path_avatar);
}

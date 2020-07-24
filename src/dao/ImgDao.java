package dao;

public interface ImgDao {
    //更新用户头像存储路径
    int updateUserAvatarPath(int user_id,String avatar_path);
}

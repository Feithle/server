package service;

import entity.Avatar;
import entity.Picture;

/**
 *
 */
public interface ImgService {
    //保存头像,返回头像的存储路径
    public String saveAvatar(Avatar avatar);
    //保存图片,返回图片的存储路径
    public String savePic(Picture picture);

}

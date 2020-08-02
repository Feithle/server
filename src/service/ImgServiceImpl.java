package service;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;
import dao.ImgDao;
import entity.Avatar;
import entity.Picture;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImgServiceImpl implements ImgService{
    @Resource
    private ImgDao imgDao;
    @Override
    public String saveAvatar(Avatar avatar) {
        //以map形式保存数据 key对应保存的是获取界面上的name名称 value保存的是获取界面上的name对应的值
        Map<String, String> map = new HashMap<String, String>();
        Part part = null;
        try {
            MultipartParser mrequest = new MultipartParser(avatar.getRequest(), 1280 * 720);
            mrequest.setEncoding("utf-8");
            //遍历所有的part组
            while ((part = mrequest.readNextPart()) != null) {
                if (part.isFile()) {  //判断是否是文件
                    FilePart filepart = (FilePart) part;//转化成文件组
                    String fileName = filepart.getFileName();//得到文件名
                    if (fileName != null && fileName.length() > 0) {
                        // 取得扩展名
                        String fileExtName = fileName.substring(
                                fileName.lastIndexOf(".") + 1).toLowerCase();
                        // 只上传图片  //判断图片上传的格式是否符合 后缀名是否有效
                        if (fileExtName.equalsIgnoreCase("jpeg")
                                || fileExtName.equalsIgnoreCase("png")
                                || fileExtName.equalsIgnoreCase("jpg")
                                || fileExtName.equalsIgnoreCase("gif")
                                || fileExtName.equalsIgnoreCase("ico")
                                || fileExtName.equalsIgnoreCase("bmp")
                                || fileExtName.equalsIgnoreCase("flv")
                                || fileExtName.equalsIgnoreCase("mp4")
                                || fileExtName.equalsIgnoreCase("mp3")) {
                            /*String newFileName = new Date().getTime() + "."+ fileExtName;//重新改文件名  文件名+扩展名 */
                            String newFileName = new Date().getTime() + fileName;//不改图片名字
                            String newPath =this.getClass().getResource("/").getPath().split("out")[0]+"web/ClientServer/avatar/"+ newFileName; //文件处理文件上传的路径
                            File newFile = new File(newPath);
                            filepart.writeTo(newFile);  //将文件真正写入到对应的文件夹中
                            map.put(filepart.getName(), newFileName);//把文件信息保存到map中
                            map.put("newFile", newFile.toString());
                        } else {
                            map.put("geshi", "geshi");
                            continue;
                        }// 说明上传的不是图片
                    } else {
                        map.put("yes", "yes");
                        continue; // 说明没有选择上传图片
                    }
                } else if (part.isParam()) {  //判断是否是参数
                    ParamPart paramPart = (ParamPart) part;
                    map.put(paramPart.getName(), paramPart.getStringValue());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map.get("newFile");
    }

    @Override
    public String savePathAvatarPath(int user_id, String path_avatar) {
        int flag=0;
        flag=imgDao.updateUserAvatarPath(user_id,path_avatar);
        if (flag==1){
            return "数据库中的头像存储路径更新成功";
        }
        return  "数据库中的头像存储路径更新失败";
    }

    @Override
    public String savePic(Picture picture) {
        return null;
    }
}

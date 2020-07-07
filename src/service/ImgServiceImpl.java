package service;

import entity.Avatar;
import entity.Picture;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.List;

@Service
public class ImgServiceImpl implements ImgService{
    @Override
    public String saveAvatar(Avatar avatar) {
        String path_avatar="";//图片全路径
        String path="";//图片所在文件
        DiskFileItemFactory diskFileItemFactory=new DiskFileItemFactory();//创建解析类的实例
        System.out.println("创建解析类的实例");
        ServletFileUpload servletFileUpload =new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setFileSizeMax(1024*99990);
        System.out.println("ok1");
        try {
            List<FileItem> items=servletFileUpload.
                    parseRequest(avatar.getRequest());//预设多个表单接收实例
            System.out.println("ok2 "+items.size());
            for (int i = 0; i < items.size(); i++) {
                FileItem fileItem=items.get(i);
                if(!fileItem.isFormField()) {//找到文件的item
                    System.out.println("这是第"+(i+1)+"个item");
                    ServletContext servletContext=avatar.getRequest().getServletContext();
                    path="C:/Users/Administrator/Desktop/EclipseWorkSpace/server/src/main/WebContent/ClientServer/avatar";
                    System.out.println("文件路径： "+path);
                    String imgName=fileItem.getName();
                    System.out.println("图片名称： "+(avatar.getUserid()+"_"+imgName));
                    path_avatar=path+"/"+(avatar.getUserid()+"_"+imgName);
                    System.out.println("图片全路径： "+path_avatar);
                    File file=new File(path_avatar);//为图片开辟一个文件空间
                    if(!file.exists()) {
                        fileItem.write(file);//文件作为文件流的参数
                        /*
                         * 文件路径写入数据库
                         */
                    }
                }else {
                    System.out.println("第"+(i+1)+"个item啥也没有");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path_avatar;
    }

    @Override
    public String savePic(Picture picture) {
        return null;
    }
}

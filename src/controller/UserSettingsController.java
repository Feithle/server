package controller;

import com.alibaba.fastjson.JSONObject;
import entity.Avatar;
import entity.ResoultOfUser;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ImgService;
import service.UserService;
import util.ReadCookie;
import util.ResponseToJs;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/UserOp")
public class UserSettingsController {
    @Resource
    private UserService userService;
    @Resource
    private ResponseToJs responseToJs;
    @Resource
    private ImgService imgService;
    @Resource
    private ReadCookie readCookie;

    @RequestMapping("/updateMessage.do")
    public void updateMessage(User user ,HttpServletResponse response ){

        ResoultOfUser resoultOfUser=new ResoultOfUser();
        resoultOfUser.setUser(user);
        resoultOfUser.setSuccess(true);
        resoultOfUser.setMsg("后台已经收到了修改用户信息表单里的文字信息");
        //输出
        String resultJson = JSONObject.toJSONString(resoultOfUser);
        try {
            responseToJs.response(resultJson,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/updateAvatar.do")
    public void updateAvatar(HttpServletRequest request){
        //请求到达controller
        System.out.println("图片保存请求到达controller");
        Avatar avatar=new Avatar();
        int userid=readCookie.getCoolieInBrowser(request).getUser_id();
        //给avatar添加两个必要的参数
        avatar.setRequest(request);//request
        avatar.setUserid(userid);//userid
        //保存avatar
        String path=imgService.saveAvatar(avatar);
        //输出path
        System.out.println("头像保存路径： "+path);
        // 获取用户id
        //保存图并返回图片存储路径
    }
}

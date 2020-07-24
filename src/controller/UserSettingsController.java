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

    /**
     * 保存用户的更新的文字信息
     * @param user
     * @param response
     */
    @RequestMapping("/updateMessage.do")
    public void updateMessage(User user ,HttpServletResponse response ){
        System.out.println(user);
        ResoultOfUser resoultOfUser=new ResoultOfUser();
        resoultOfUser=userService.updateUserMessage(user);
        //输出
        String resultJson = JSONObject.toJSONString(resoultOfUser);
        try {
            responseToJs.response(resultJson,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存用户头像
     * @param request
     */
    @RequestMapping("/updateAvatar.do")
    public String updateAvatar(HttpServletRequest request){
        //请求到达controller
        Avatar avatar=new Avatar();
        int userid=readCookie.getCoolieInBrowser(request).getUser_id();
        //给avatar添加两个必要的参数
        avatar.setRequest(request);//request
        avatar.setUserid(userid);//userid
        //保存avatar
        String path=imgService.saveAvatar(avatar);
        //输出path
        System.out.println("头像保存路径： "+path);
        //保存图片存储路径
        System.out.println(imgService.savePathAvatarPath(userid,path));
        //控制页面的跳转
        return "forward:/index.jsp";
    }
}

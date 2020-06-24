package controller;

import com.alibaba.fastjson.JSONObject;
import entity.ResoultOfUser;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;
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
        System.out.println("头像上传功能:");
        //先测试是否获取到图片
        //获取用户id
        //保存图并返回图片存储路径


    }
}

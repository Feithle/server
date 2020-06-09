package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/UserOp")
public class UserSettingsController {
    @Resource
    private UserService userService;

    @RequestMapping("/updateMessage.do")
    public String updateMessage(User user){
        System.out.println(user);
        //待完成...
        return null;
    }


    @RequestMapping("/updateMessage.do")
    public String updateAvatar(HttpServletRequest request){
        //待完成...
        return null;
    }
}

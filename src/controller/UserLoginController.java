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
import javax.swing.text.AbstractDocument;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/UserOp")
public class UserLoginController {
    @Resource
    private UserService userService;
    @Resource
    private ResponseToJs responseToJs;
    /**
     * TODO 读取cookie中保存的user信息，返回到js
     * @param request
     */
    @RequestMapping("/fillInputTag.do")
    public void fillInputTag(HttpServletRequest request,HttpServletResponse response){

        //获取
        User user=userService.fillInputTag(request);
        //包装
        ResoultOfUser resoultOfUser=new ResoultOfUser();
        if(user !=null){
            resoultOfUser.setSuccess(true);
            resoultOfUser.setUser(user);
        }
        //输出
        String resultJson = JSONObject.toJSONString(user);
        try {
            responseToJs.response(resultJson,response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @RequestMapping("/login.do")
    public void login(User user,HttpServletResponse response) throws IOException {
       ResoultOfUser resoultOfUser=userService.UserLoginVertify(user);

       if (resoultOfUser.success){
           if (resoultOfUser.getUser().getPassword().equals(user.getPassword())){
               //更新cookie
               userService.updateCookies(user,response);
               //提示
               resoultOfUser.setMsg("登录成功");
               //输出
               String resultJson = JSONObject.toJSONString(resoultOfUser);
               responseToJs.response(resultJson,response);
               //测试
               System.out.println(resultJson);
           }else{
               //提示
               resoultOfUser.setMsg("登录失败，密码错误");
               //输出
               String resultJson = JSONObject.toJSONString(resoultOfUser);
               try {
                   responseToJs.response(resultJson,response);
               }catch (Exception e){
                   e.printStackTrace();
               }
           }
       }else {
           //提示
           resoultOfUser.setMsg("错误，用户不存在");
           //输出
           String resultJson = JSONObject.toJSONString(resoultOfUser);
           try {
               responseToJs.response(resultJson,response);
           }catch (Exception e){
               e.printStackTrace();
           }
       }
    }

    @RequestMapping("/loadStatue.do")
    public void loadStatue(HttpServletRequest request,HttpServletResponse response){
        User user=userService.fillInputTag(request);
        ResoultOfUser resoultOfUser=new ResoultOfUser();
        resoultOfUser.setMsg("读取了浏览器中的cookie");
        if (user!=null){//不为空则读取成功
            resoultOfUser.setSuccess(true);
            resoultOfUser.setUser(user);
        }else{
            resoultOfUser.setSuccess(false);
        }
        //输出
        String resultJson = JSONObject.toJSONString(resoultOfUser);
        try {
            responseToJs.response(resultJson,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
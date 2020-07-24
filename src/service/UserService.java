package service;

import entity.ResoultOfUser;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    //添加用户
    void regist(String email, String password);
    //根据id返回完整用户
    User getUserByEmail(String email);
    //更新cookie
    void updateCookies(User user, HttpServletResponse response);
    //读取cookie,返回一个user
    User fillInputTag( HttpServletRequest request);
    //登录用户
    ResoultOfUser UserLoginVertify(User user);
    //修改用户信息
    ResoultOfUser UpdateUserMessage(User user);
}

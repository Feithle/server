package service;


import dao.UserDao;
import entity.ResoultOfUser;
import entity.User;
import org.springframework.stereotype.Service;
import util.ReadCookie;
import util.UpdateCookie;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;
    @Resource
    private UpdateCookie updateCookie;
    @Resource
    private ReadCookie readCookie;
    @Override
    public void regist(String email, String password) {
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        userDao.add(user);
    }

    /**
     * @param email
     * @return
     */
    @Override
    public User getUserByEmail(String email) {
        User user=new User();
        user=userDao.quarryUser(email);
        return user;
    }


    @Override
    public void updateCookies(User user , HttpServletResponse response) {
        if(updateCookie.insertCookiesForLogin(user,response)){
            System.out.println("cookie更新完成");
        }
    }

    @Override
    public User fillInputTag(HttpServletRequest request) {
        return  readCookie.getCoolieInBrowser(request);
    }

    @Override
    public ResoultOfUser UserLoginVertify(User user) {
        ResoultOfUser resoultOfUser =new ResoultOfUser();
        resoultOfUser.setSuccess(userDao.vertifyEmail(user.getEmail()));
        if (resoultOfUser.success){
            resoultOfUser.setUser(userDao.quarryUser(user.getEmail()));
        }
        return resoultOfUser;
    }

    @Override
    public ResoultOfUser updateUserMessage(User user) {
        ResoultOfUser resoultOfUser=new ResoultOfUser();
        int flag=0;
        resoultOfUser.setUser(user);
        flag=userDao.updateUserMessage(user);
        if (flag==1){
            resoultOfUser.success=true;
        }else {
            resoultOfUser.setMsg("本次用户信息更新失败");
        }
        return resoultOfUser;
    }


}

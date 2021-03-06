package util;

import entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
@Service
public class UpdateCookie {
    Boolean flag=false;
    Cookie cookie_email = null;
    Cookie cookie_password = null;
    Cookie cookie_user_id = null;
    Cookie cookie_path_avatar_lqy=null;
    public boolean insertCookiesForLogin(User user , HttpServletResponse response){
        cookie_email = new Cookie("email_lqy", user.getEmail());
        cookie_password = new Cookie("password_lqy", user.getPassword());
        cookie_user_id = new Cookie("user_add_id_lqy", String.valueOf(user.getUser_id()));
        cookie_path_avatar_lqy=new Cookie("cookie_path_avatar_lqy", user.getPath_avatar());
        // 默认关闭本次会话,cookie关闭。
        try {
            response.addCookie(cookie_email);
            response.addCookie(cookie_password);
            response.addCookie(cookie_user_id);
            response.addCookie(cookie_path_avatar_lqy);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}

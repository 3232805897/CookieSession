package Cookie;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUntil {
    //获取指定名字的cookie
    public static Cookie getCookie(String name, Cookie[] cookies){
        if (name == null|"".equals(name)|cookies==null|cookies.length==0){
            return null;
        }else {
            //进行遍历
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }

    //修改cookie的value
    public static void updateCookie(String name, String value, Cookie[] cookies, HttpServletResponse response){
        //先判断该cookie是否存在
        Cookie cookie = getCookie(name, cookies);
        if (cookie == null){
            System.out.println("修改失败，没有该cookie");
        }else {
            cookie.setValue(value);
            response.addCookie(cookie);
        }
    }
}

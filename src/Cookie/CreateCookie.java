package Cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建cookie对象,传给浏览器
        Cookie cookie1 = new Cookie("username", "aa");
        response.addCookie(cookie1);

        Cookie[] cookies = request.getCookies();
        //读取指定的cookie
        Cookie cookie = CookieUntil.getCookie("username", cookies);

        CookieUntil.updateCookie("username","aaa",cookies,response);
        //修改了记得打回浏览器
        response.addCookie(cookie);
    }
}

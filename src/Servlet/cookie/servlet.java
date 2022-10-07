package Servlet.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Cookie[] cookies = request.getCookies();
        Cookie cookie2 = null;
        if(cookies!=null){
            for(Cookie cookie:cookies) {
                if(cookie.getName().equals("user") && cookie.getValue().equals("1")){
                    cookie2 = cookie;
                    break;
                }
            }
        }
        if(cookie2!=null){
            writer.println("嗨，欢迎您再次到 from zero to expert.");
        }else{
            Cookie cookie = new Cookie("user","1");
            cookie2 = cookie;
            response.addCookie(cookie2);
            writer.println("嗨，欢迎您到 from zero to expert.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

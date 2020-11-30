package org.example.servlrt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with Intellij IFEA
 * Description:
 * User : 花朝
 * Date : 2020-11-29
 * Time : 18:28
 */
@WebServlet("/sen")
public class SensitiveServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");//响应头Content-type，告诉堆端响应体的解析；
        PrintWriter pw = resp.getWriter();
        // 敏感资源，需要使用false传参，如果没有，返回null
        HttpSession session = req.getSession(false);
        if(session == null){
            resp.setStatus(401);
            pw.println("没有登陆，不许访问");
        }else {
            //伪代码
//            User user = (User) session.getAttribute("user");
//            if(user.允许访问的资源不包含当前访问的服务路径){
//                resp.setStatus(403);
//                pw.println("禁止访问");
//            }else {
                pw.println("访问成功");
        }
    }
}

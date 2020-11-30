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
 * Time : 11:51
 */
//定义当前类为Servlet （服务端Java代码提供的Java服务）
//服务路径必须以/开头，否则tomcat启动就会报错；
@WebServlet("/loginUseSession")
public class LoginUseSessionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求的编码格式;
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");//响应头Content-type，告诉堆端响应体的解析；
        //请求数据getParameter可以获取url中的queryString请求数据，及请求体表单数据类型格式的请求数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.printf("username=%s,password=%s%n",username,password);

        PrintWriter pw = resp.getWriter();
    //伪代码；用户名登录的jdbc校验；
//        if(LoginDAO.query(username,password)){
//            pw.println("登录成功");
//        }else{
//            pw.println("登录失败");
//        }
        //模拟用户名密码登录：登陆成功
        if("myh".equals(username) && "666".equals(password)){
            //获取session对象，从服务端获取；
            //如果方法参数为true，表示如果没有，就创建一个；
            //如果为false，表示没有就返回null
            HttpSession session = req.getSession();//无参默认是true；
            session.setAttribute("user",String.format("username=%s,password=%s",username,password));
            pw.println("登录成功");
        }else {
            pw.println("登录失败");
        }
        pw.flush();
        pw.close();
    }
}

package servlet;

import classes.Mails;
import classes.User;
import dao.MailDao;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import utilss.MyUtils;
import utilss.MybatisUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/Send")
public class Sendmail extends HttpServlet {
    static SqlSession sqlSession;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String theme = request.getParameter("theme");
        String receiver = request.getParameter("receiver");
        String content = request.getParameter("content");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(10 * 60);
        sqlSession = MybatisUtils.getSqlSession();
        UserDao ud = sqlSession.getMapper(UserDao.class);
        User u = ud.getUserById(receiver);
        if (u == null) {
            request.setAttribute("attention", "此收件人用户名不存在");
        } else {
            request.setAttribute("attention", "");
            MailDao md = sqlSession.getMapper(MailDao.class);
            md.addReceiveMails(new Mails(null, theme, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), MyUtils.getUserid(request.getSession()), receiver));
            String fileName = "D:\\Servlet_test\\src\\main\\java\\mailfile\\" + '5' + ".txt";
            File file = new File(fileName);
            if (!file.exists()) file.createNewFile();
            try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
                bf.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSession.commit();
            request.setAttribute("msg", "发送成功");
            MyUtils.updatemail(request.getSession());
        }
        request.getRequestDispatcher("jsp/write.jsp").forward(request, response);
    }
}

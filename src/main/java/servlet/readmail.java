package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import classes.Mails;
import dao.MailDao;
import org.apache.ibatis.session.SqlSession;
import utilss.MyUtils;
import utilss.MybatisUtils;

@WebServlet(name = "readmail", value = "/readmail")
public class readmail extends HttpServlet {
    static SqlSession sqlSession;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getQueryString();
        char type = s.charAt(0);//1是发件箱 2是收件箱
        int id = Character.getNumericValue(s.charAt(1));
        sqlSession = MybatisUtils.getSqlSession();
        MailDao md = sqlSession.getMapper(MailDao.class);
        Mails m = md.getMail(id);
        request.setAttribute("theme", m.getTheme());
        request.setAttribute("date", m.getEmail_Date());
        request.setAttribute("receiver",m.getTo_id());
        String file = "D:\\Servlet_test\\src\\main\\java\\mailfile\\" + id + ".txt";
        request.setAttribute("content", Files.readString(Path.of(file)));
        request.setAttribute("mailtype", type == '1' ? 1 : 2);
        request.getRequestDispatcher("jsp/mail.jsp").forward(request,response);
    }
}

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

@WebServlet(name = "readdraft", value = "/readdraft")
public class readdraft extends HttpServlet {
    static SqlSession sqlSession;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getQueryString();
        int id = Character.getNumericValue(s.charAt(0));
        sqlSession = MybatisUtils.getSqlSession();
        MailDao md = sqlSession.getMapper(MailDao.class);
        Mails m = md.getDraftMail(id);
        System.out.println(m.getTheme());
        request.setAttribute("theme", m.getTheme());
        request.setAttribute("emailid", m.getId());
        String file = "D:\\Servlet_test\\src\\main\\java\\mailfile\\" + id + ".txt";
        request.setAttribute("content", Files.readString(Path.of(file)));
        request.getRequestDispatcher("jsp/editmail.jsp").forward(request, response);
    }
}

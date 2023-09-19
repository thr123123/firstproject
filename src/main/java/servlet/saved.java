package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import classes.Mails;
import dao.MailDao;
import org.apache.ibatis.session.SqlSession;
import utilss.MyUtils;
import utilss.MybatisUtils;

@WebServlet(name = "saved", value = "/saved")
public class saved extends HttpServlet {
    static SqlSession sqlSession;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getQueryString();
        sqlSession = MybatisUtils.getSqlSession();
        MailDao md = sqlSession.getMapper(MailDao.class);
        request.setAttribute("theme", request.getParameter("theme"));
        request.setAttribute("content", request.getParameter("content"));
        String c = request.getParameter("content");
        String fileName = "D:\\Servlet_test\\src\\main\\java\\mailfile\\" + s + ".txt";
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(fileName))) {
            bf.write(c);
        } catch (IOException e) {
            e.printStackTrace();
        }
        md.updateMail(request.getParameter("theme"), request.getParameter("receiver"), Character.getNumericValue(s.charAt(0)));
        sqlSession.commit();
        request.setAttribute("msg", "保存成功");
        request.getRequestDispatcher("jsp/editmail.jsp").forward(request, response);
    }
}

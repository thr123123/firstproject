package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import classes.Mails;
import dao.MailDao;
import org.apache.ibatis.session.SqlSession;
import utilss.MyUtils;
import utilss.MybatisUtils;

@WebServlet(name = "savedraft", value = "/savedraft")
public class savedraft extends HttpServlet {
    static SqlSession sqlSession;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String theme=request.getParameter("theme");
        String receiver=request.getParameter("receiver");
        String content=request.getParameter("content");
        sqlSession=MybatisUtils.getSqlSession();
        MailDao md=sqlSession.getMapper(MailDao.class);
        md.addDraftMails(new Mails(8,theme,new SimpleDateFormat("yyyy-MM-dd").format(new Date()),MyUtils.getUserid(request.getSession()),receiver));
        String fileName = "D:\\Servlet_test\\src\\main\\java\\mailfile\\" + '8' + ".txt";
        File file = new File(fileName);
        if (!file.exists()) file.createNewFile();
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(file))) {
            bf.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession.commit();
        request.setAttribute("msg","存入草稿箱成功");
        MyUtils.updatemail(request.getSession());
        request.getRequestDispatcher("jsp/write.jsp").forward(request,response);
    }
}

package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import dao.AddressDao;
import dao.MailDao;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import utilss.MyUtils;
import utilss.MybatisUtils;

@WebServlet(name = "delUser", value = "/delUser")
public class delUser extends HttpServlet {
    static SqlSession sqlSession;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] user=request.getParameterValues("select");
        sqlSession=MybatisUtils.getSqlSession();
        UserDao ud=sqlSession.getMapper(UserDao.class);
        MailDao md=sqlSession.getMapper(MailDao.class);
        AddressDao ad=sqlSession.getMapper(AddressDao.class);
        for(String u:user){
            ud.delUser(u);
            md.delReceiveMails(u);
            ad.delAddr(u);
            md.delDraftMails(u);
        }
        request.setAttribute("att","删除成功");
        MyUtils.updateuser(request.getSession());
        request.getRequestDispatcher("jsp/usermanage.jsp").forward(request,response);
    }
}

package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import classes.User;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import utilss.MyUtils;
import utilss.MybatisUtils;

@WebServlet(name = "addUser", value = "/addUser")
public class addUser extends HttpServlet {
    static SqlSession sqlSession;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        sqlSession = MybatisUtils.getSqlSession();
        UserDao ud = sqlSession.getMapper(UserDao.class);
        if (ud.getUserId(id) != null)
            request.setAttribute("att", "用户名已存在");
        else {
            String pwd = request.getParameter("pwd");
            String usertype = request.getParameter("usertype");
            ud.addUser(new User(id, MyUtils.encryptToMD5(pwd), usertype.equals("admin")));
            sqlSession.commit();
            MyUtils.updateuser(request.getSession());
            request.setAttribute("att", "添加成功");
        }
        request.getRequestDispatcher("jsp/usermanage.jsp").forward(request, response);
    }
}

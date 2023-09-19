package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import classes.User;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import utilss.MyUtils;
import utilss.MybatisUtils;

import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {
    static SqlSession sqlSession;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String usertype = request.getParameter("usertype");
        HttpSession hs = request.getSession();
        hs.setMaxInactiveInterval(10 * 60);
        if (checksql(username, password, !usertype.equals("usr"))) {
            hs.setAttribute("user", username);
            response.sendRedirect("jsp/registers.jsp");
        } else {
            request.setAttribute("attention", "账户已存在");
            request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
        }
    }

    public boolean checksql(String usr, String pwd, boolean usertype) {
        sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User u = mapper.getUserById(usr);
        if (u != null)
            return false;
        mapper.addUser(new User(usr, MyUtils.encryptToMD5(pwd), usertype));
        sqlSession.commit();
        return true;
    }
}

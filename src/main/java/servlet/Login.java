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
import java.util.Objects;

@WebServlet(name="Login",value = {"/Login"})
public class Login extends HttpServlet {
    static SqlSession sqlSession;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (checksql(username, password, request.getSession())) {
            MyUtils.init(request.getSession());
            response.sendRedirect("jsp/welcome.jsp");
        } else {
            request.setAttribute("attention", "用户名或密码错误");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    public boolean checksql(String name, String pwd, HttpSession hs) {
        sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User u = mapper.getUserById(name);
        if (u == null)
            return false;
        else {
            hs.setAttribute("user", u.getId());
            hs.setAttribute("usertype", u.getIsadmin());
            return Objects.equals(u.getPwd(), MyUtils.encryptToMD5(pwd));
        }
    }
}

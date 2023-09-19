package servlet;

import classes.address;
import dao.AddressDao;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;
import utilss.MyUtils;
import utilss.MybatisUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addAddr", value = {"/addAddr"})
public class addAddr extends HttpServlet {
    static SqlSession sqlSession;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String a = request.getParameter("id");
        request.setAttribute("att", "");
        if (checksql(a, request))
            MyUtils.updateaddress(request.getSession());
        request.getRequestDispatcher("jsp/addr.jsp").forward(request, response);
    }

    public static boolean checksql(String u, HttpServletRequest request) {
        sqlSession = MybatisUtils.getSqlSession();
        UserDao ud = sqlSession.getMapper(UserDao.class);
        AddressDao ad = sqlSession.getMapper(AddressDao.class);
        String id = ud.getUserId(u);
        String userid = MyUtils.getUserid(request.getSession());
        if (id == null) {
            request.setAttribute("att", "该用户名不存在");
            return false;
        } else if (id.equals(userid)) {
            request.setAttribute("att", "不能添加自己为联系人");
            return false;
        } else if (id.equals(ad.getUserbyId(u, userid))) {
            request.setAttribute("att", "该联系人已存在");
            return false;
        }
        ad.insertAddress(new address(u, MyUtils.getUserid(request.getSession())));
        sqlSession.commit();
        request.setAttribute("att", "添加成功");
        MyUtils.updateaddress(request.getSession());
        return true;
    }
}

package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import classes.address;
import dao.AddressDao;
import org.apache.ibatis.session.SqlSession;
import utilss.MyUtils;
import utilss.MybatisUtils;

@WebServlet(name = "delAddr", value = "/delAddr")
public class delAddr extends HttpServlet {
    static SqlSession sqlSession;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] delid=request.getParameterValues("select");
        sqlSession=MybatisUtils.getSqlSession();
        AddressDao ad=sqlSession.getMapper(AddressDao.class);
        String userid=MyUtils.getUserid(request.getSession());
        for(String s:delid)
            ad.deleteAddress(new address(s,userid));
        sqlSession.commit();
        request.setAttribute("att","删除成功");
        MyUtils.updateaddress(request.getSession());
        request.getRequestDispatcher("jsp/addr.jsp").forward(request, response);
    }
}

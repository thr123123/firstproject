package utilss;

import classes.User;
import dao.AddressDao;
import dao.MailDao;
import dao.UserDao;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpSession;
import java.security.MessageDigest;

public class MyUtils {
    static SqlSession sqlSession;

    public static void init(HttpSession hs) {
        updatemail(hs);
        updateaddress(hs);
        updateuser(hs);
    }

    //更新发件箱与收件箱
    public static void updatemail(HttpSession hs) {
        sqlSession = MybatisUtils.getSqlSession();
        MailDao md = sqlSession.getMapper(MailDao.class);
        hs.setAttribute("allsendEmails", md.getAllSendMails(getUserid(hs)));
        hs.setAttribute("allreceiveEmails", md.getAllReceiveMails(getUserid(hs)));
        hs.setAttribute("alldraftEmails",md.getAllDraftMails(getUserid(hs)));
    }

    public static String getUserid(HttpSession hs) {
        return (String) hs.getAttribute("user");
    }

    public static void updateaddress(HttpSession hs) {
        sqlSession = MybatisUtils.getSqlSession();
        AddressDao ad = sqlSession.getMapper(AddressDao.class);
        hs.setAttribute("allAddress", ad.getAlladdress(getUserid(hs)));
    }

    public static void updateuser(HttpSession hs) {
        sqlSession = MybatisUtils.getSqlSession();
        UserDao ud = sqlSession.getMapper(UserDao.class);
        hs.setAttribute("allUser", ud.getUserList(getUserid(hs)));
    }

    public static String encryptToMD5(String strs) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bs = digest.digest(strs.getBytes());
            for (byte b : bs) {
                int x = b & 255;
                String s = Integer.toHexString(x);
                if (x > 0 && x < 16) {
                    sb.append("0");
                    sb.append(s);
                } else {
                    sb.append(s);
                }
            }
        } catch (Exception e) {
            System.out.println("加密失败");
        }
        return sb.toString();
    }
}

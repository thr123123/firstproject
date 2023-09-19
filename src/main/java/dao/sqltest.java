package dao;

import org.apache.ibatis.session.SqlSession;
import utilss.MybatisUtils;

public class sqltest {
    static SqlSession sqlSession;

    public static void test(){
        try{
            sqlSession= MybatisUtils.getSqlSession();
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
        test();
    }
}

package dao;

import classes.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList(String id);//获取除自己以外的用户列表
    User getUserById(String id);
    void addUser(User s);
    String getUserId(String id);
    void delUser(String id);
}

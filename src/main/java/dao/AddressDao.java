package dao;

import classes.address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    List<address> getAlladdress(String id);//获取所有该用户的联系人

    String getUserbyId(@Param("id") String id, @Param("uid") String u_id);//判断该联系人是否存在

    void insertAddress(address user);//添加联系人

    void deleteAddress(address user);//删除制定联系人

    void delAddr(String u);//删除联系人数据
}

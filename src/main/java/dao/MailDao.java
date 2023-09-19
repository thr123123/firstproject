package dao;

import classes.Mails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MailDao {
    List<Mails> getAllDraftMails(String username);
    //获取该用户发件箱所有邮件
    List<Mails> getAllSendMails(String username);
    //获取该用户收件箱所有邮件
    List<Mails> getAllReceiveMails(String username);
    Mails getMail(int id);
    Mails getDraftMail(int id);
    void updateMail(@Param("theme") String theme,@Param("to_id") String to_id,@Param("id") int id);
    void addReceiveMails(Mails m);
    void addDraftMails(Mails m);
    void delDraftMails(String id);
    void delReceiveMails(String id);
}

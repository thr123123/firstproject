package classes;

public class Mails {
    Integer id;
    String theme;
    String email_Date;
    String from_id;
    String to_id;

    public Mails() {
    }

    public Mails(Integer id, String theme, String Email_date, String from_id, String to_id) {
        this.id = id;
        this.theme = theme;
        this.email_Date = Email_date;
        this.from_id = from_id;
        this.to_id = to_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    public String getFrom_id() {
        return from_id;
    }

    public String getEmail_Date() {
        return email_Date;
    }

    public void setEmail_Date(String email_Date) {
        this.email_Date = email_Date;
    }

    public void setFrom_id(String from_id) {
        this.from_id = from_id;
    }

    public String getTo_id() {
        return to_id;
    }

    @Override
    public String toString() {
        return "Mails{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", email_Date='" + email_Date + '\'' +
                ", from_id='" + from_id + '\'' +
                ", to_id='" + to_id + '\'' +
                '}';
    }

    public void setTo_id(String to_id) {
        this.to_id = to_id;
    }

}

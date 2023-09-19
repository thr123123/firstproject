package classes;

import java.io.Serializable;

public class User implements Serializable {
    private String id;
    private String pwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    private boolean isadmin;

    public User() {
    }

    public User(String id, String pwd, boolean isadmin) {
        this.id = id;
        this.pwd = pwd;
        this.isadmin = isadmin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id + '\'' +
                ",pwd='" + pwd + '\'' +
                ",isadmin=" + isadmin + '\'' +
                '}';
    }
}

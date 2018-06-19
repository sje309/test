package dbUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/4 11:00
 * @Description:
 */
public class UsersBean implements Serializable {
    private static final long serialVersionUID = -4240187412463730714L;
    private int id;
    private String name;
    private String password;
    private String email;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String result = String.format("[id=%d,name=%s,password=%s,email=%s]", id, name, password, email);
        return result;
    }
}

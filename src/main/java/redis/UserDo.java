package redis;

import java.io.Serializable;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/8 16:12
 * @Description:
 */
public class UserDo implements Serializable {
    private static final long serialVersionUID = 5949542012818573459L;
    private int userId;
    private int sex;
    private String Uname;
    private String email;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        String result = String.format("[userId:%d,sex:%d,Uname:%s,email:%s]", userId, sex, Uname, email);
        return result;
    }
}

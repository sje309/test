import java.io.Serializable;

/** @Author: shuyizhi @Date: 2018-08-13 14:03 @Description: */
public class UserModel implements Serializable {
    private static final long serialVersionUID = 6977720446314988413L;
    private int id;
    private String name;
    private String password;

    public UserModel(int id, String name, String password) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
    }

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

    @Override
    public String toString() {
        return "UserModel{"
                + "id="
                + id
                + ", name='"
                + name
                + '\''
                + ", password='"
                + password
                + '\''
                + '}';
    }
}

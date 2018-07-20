package autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-19 16:31
 * @Description:
 */
public class Customer {
    @Autowired      //属性(字段)注解
    @Qualifier(value = "personAutoWired2")
    private Person person;
    private int type;
    private String action;

    public Person getPerson() {
        return person;
    }

    //@Autowired  //setter方法注解
    public void setPerson(Person person) {
        this.person = person;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    //@Autowired      //构造函数注解
    //public Customer(Person person) {
    //    this.person = person;
    //}

    @Override
    public String toString() {
        return "Customer{" +
                "person=" + person +
                ", type=" + type +
                ", action='" + action + '\'' +
                '}';
    }
}

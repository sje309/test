package model;

import java.io.Serializable;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-12 14:24
 * @Description:
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -8950945688057768215L;
    private Integer age;
    private String name;
    private Integer id;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[id: " + id + ", age: " + age + ", name: " + name + "]";
    }
}

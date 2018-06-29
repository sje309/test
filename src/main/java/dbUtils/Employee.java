package dbUtils;

import java.io.Serializable;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/8 11:23
 * @Description:
 */
public class Employee implements Serializable {

    private String id;
    private String name;
    private double salary;
    private Department department;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

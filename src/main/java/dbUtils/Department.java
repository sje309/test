package dbUtils;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: shuyizhi
 * @Date: 2018/4/8 11:21
 * @Description:
 */
public class Department implements Serializable {
    private static final long serialVersionUID = -1743887587062356366L;
    private String id;
    private String name;
    private Set employees = new HashSet();

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

    public Set getEmployees() {
        return employees;
    }

    public void setEmployees(Set employees) {
        this.employees = employees;
    }
}

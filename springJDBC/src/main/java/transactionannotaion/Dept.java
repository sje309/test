package transactionannotaion;

import java.io.Serializable;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-12 17:25
 * @Description:
 */
public class Dept implements Serializable {
    private static final long serialVersionUID = 4663236112565339000L;
    private int deptId;
    private String deptName;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "[deptId: " + deptId + ",deptName: " + deptName + "]";
    }
}

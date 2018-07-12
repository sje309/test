/**
 * @Author: shuyizhi
 * @Date: 2018-07-12 17:08
 * @Description:
 */
public class DeptService {
    //容器注入Dao
    private DeptDao deptDao;

    public void setDeptDao(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public void save(Dept dept) {
        //第一次调用
        deptDao.saveByTransaction(dept);
        //产生异常
        //int i = 1 / 0;          //事务遇到异常会回滚
        //第二次调用
        deptDao.saveByTransaction(dept);
    }
}

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-12 11:22
 * @Description:
 */
public class DeptDaoTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
    private DeptDao dao = (DeptDao) context.getBean("deptDao");
    private DeptService deptService = (DeptService) context.getBean("deptService");     //事务

    @Test
    public void save() {
        //dao.save();

        //region 事务管理测试
        Dept dept = new Dept();
        dept.setDeptName("事务测试");
        deptService.save(dept);
        //endregion
    }

    @Test
    public void findById() {
        Dept dept = dao.findById(1);
        if (null != dept) {
            System.out.println(dept.toString());
        }
    }

    @Test
    public void getAll() {
        List<Dept> list = dao.getAll();
        if (null != list && list.size() > 0) {
            for (Dept dept : list) {
                System.out.println(dept.toString());
            }
        }
    }
}
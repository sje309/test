package transactionannotaion;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-13 9:13
 * @Description:
 */
@Service
//DeptService加入容器(如果不加此注解，需要在xml中配置bean <bean id="deptService" class="transactionannotaion.DeptService"></bean>)
public class DeptService {
    @Resource
    private DeptDao deptDao;

    @Transactional(propagation = Propagation.REQUIRED) //对该方法实行事务
    public void save(Dept dept) {
        //第一次调用
        deptDao.save(dept);
        //产生异常
        int i = 1 / 0;      //事务遇到异常会回滚
        //第二次调用
        deptDao.save(dept);
    }
}

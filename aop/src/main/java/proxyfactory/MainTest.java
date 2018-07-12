package proxyfactory;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 17:25
 * @Description: 测试
 * 参考：http://blog.51cto.com/dba10g/1785667
 */
public class MainTest {
    public static void main(String[] args) {
        //1、初始化源对象(一定要实现接口)
        UserService target = new UserServiceImpl();
        //2、AOP代理工厂
        ProxyFactory pf = new ProxyFactory(target);
        //3、装配Advice
        pf.addAdvice(new SecurityInterceptor());
        pf.addAdvisor(new DefaultIntroductionAdvisor(new LoggerBeforeAdvice()));
        //4、获取代理对象
        UserService proxy = (UserService) pf.getProxy();
        //5、调用业务
        proxy.updateUser();
    }
}

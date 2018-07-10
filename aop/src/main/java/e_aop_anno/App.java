package e_aop_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-10 16:55
 * @Description: 抽取出来的切面对象
 * 参考: http://www.cnblogs.com/cenyu/p/6291831.html
 */
@Component
@Aspect     //指定当前类为切面类
public class App {
    //指定切入点表达式：拦截哪些方法，即为哪些类生成代理对象
    @Pointcut(value = "execution(* e_aop_anno.*.*(..))")
    //@Pointcut(value = "execution(* e_aop_anno.UserDao.save(..))")     //只拦截UserDao中的save()方法
    public void pointCut_() {

    }

    //前置通知:在执行目标方法之前执行
    @Before(value = "pointCut_()")
    public void begin() {
        System.out.println("开始事务/异常");
    }

    //后置/最终通知:在执行目标方法之后执行(无论是否出现异常最终都会执行)
    @After(value = "pointCut_()")
    public void after() {
        System.out.println("提交事务/关闭");
    }

    //返回后通知：在调用目标方法结束后执行(出现异常不执行)
    @AfterReturning(value = "pointCut_()")
    public void afterReturning() {
        System.out.println("afterReturning()");
    }

    //异常通知:当目标方法执行异常时候执行此关注点代码
    @AfterThrowing(value = "pointCut_()")
    public void afterThrowing() {
        System.out.println("afterThrowing()");
    }

    @Around("pointCut_()")
    public void around(ProceedingJoinPoint joinPoint)
            throws Throwable {

    }
}

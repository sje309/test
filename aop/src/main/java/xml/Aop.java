package xml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 13:51
 * @Description: 切面类 使用XML配置的方式实现Aop
 */
public class Aop {
    public void begin() {
        System.out.println("开始事务/异常");
    }

    public void after() {
        System.out.println("提交事务/异常");
    }

    public void afterReturning() {
        System.out.println("afterReturning");
    }

    public void afterThrowing() {
        System.out.println("afterThrowning()");
    }

    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前....");
        pjp.proceed();
        System.out.println("环绕后...");
    }
}

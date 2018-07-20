package aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-20 14:29
 * @Description:
 */
@Aspect
public class LoggingAspect {
    /**
     * 指定切入点表达式：拦截哪些方法，即为哪些类生成代理对象
     */
    @Pointcut(value = "execution(* aspectJ.CustomerBo.*(..))")
    public void pointCut_() {

    }

    //@Before(value = "execution(* aspectJ.CustomerBo.addCustomer(..))")  //只拦截addCustomer()方法
    @Before(value = "pointCut_()")
    public void logBefore() {
        System.out.println("logBefore() is running");
        System.out.println("**********************");
    }

    @After(value = "pointCut_()")
    public void logAfter() {
        System.out.println("logAfter() is running!");
        System.out.println("=======================");
    }

    @AfterReturning(value = "pointCut_()", returning = "result")
    public void logAfterReturn(JoinPoint joinPoint, Object result) {
        System.out.println("logAfterThrowing() is running");
        System.out.println("MethodName: " + joinPoint.getSignature().getName());
        System.out.println("Method returned value is：" + result);
        System.out.println("**********************");
    }

    @AfterThrowing(value = "pointCut_()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("logAfterThrowing() is running!");
        System.out.println("MethodName: " + joinPoint.getSignature().getName());
        System.out.println("Exception: " + error);
        System.out.println("**********************");
    }

    //@Around(value = "pointCut_()")
    @Around(value = "execution(* CustomerBo.addCustomerAround(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("logAround() is running!");
        System.out.println("Method Name: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running!");
        joinPoint.proceed();
        System.out.println("Around after is running!");
        System.out.println("******************************");
    }
}

package calclog;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 15:40
 * @Description:
 */
//把这个类声明为切面：需要将该类放入IOC容器中，再声明一个切面
@Order(value = 0)   //指定切面优先级，值越小优先级越高
@Aspect
@Component
public class LoggingAspect {

    /**
     * 定义一个方法，用于声明切入点表达式，一般该方法中不需要添加其他代码
     * 主要是为了重用路径，使用@Pointcut注解来声明切入点表达式
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式
     */
    @Pointcut(value = "execution(* calclog.CalculatorImpl.*(..))")
    public void declareJointPointExpression() {

    }

    //声明该方法为一个前置通知：在目标方法之前执行
    @Before(value = "declareJointPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("\n====================前置通知before======================");
        String methodName = joinPoint.getClass().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The Method " + methodName + " Begin With " + args);
    }

    //在目标方法执行之后执行，无论这个方法是否出错
    //在后置通知中还不能访问目标方法的返回值，只能通过返回通知访问
    @After(value = "execution(* calclog.CalculatorImpl.*(int,int))")
    public void afterMethod(JoinPoint joinPoint) {
        System.out.println("\n====================后置通知after======================");
        String methodName = joinPoint.getClass().getName();
        System.out.println("The Method " + methodName + " Ends");
    }

    /**
     * 在方法正常结束后执行的代码
     * 返回通知是可以访问到方法的返回值
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "execution(* calclog.CalculatorImpl.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("\n====================前置通知afterReturning======================");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method " + methodName + " Ends With " + result);
    }

    /**
     * 在目标方法出现异常的时候执行代码
     * 可以访问异常对象,切可以指定出特定异常时再执行通知
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "execution(* calclog.CalculatorImpl.*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        System.out.println("\n====================异常通知afterThrowing======================");
        String methodName = joinPoint.getSignature().getName();
        System.out.println("The Method " + methodName + " Occurs With " + ex);
    }

    /**
     * 环绕通知需要ProceedingJoinPoint 参数类型，功能最强大
     * 环绕通知类似于动态代理的全过程:ProceedingJoinPoint 类型的参数可以决定是否执行目标方法
     * 且环绕通知必须有返回值，返回值即为目标方法的返回值
     *
     * @param proceedingJoinPoint
     * @return
     */
    @Around(value = "execution(* calclog.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("\n====================环绕通知around======================");
        try {
            //前置通知
            System.out.println("The Method " + methodName + " Begin With " +
                    Arrays.asList(proceedingJoinPoint.getArgs()));
            //执行目标方法
            result = proceedingJoinPoint.proceed();
            //返回通知
            System.out.println("The Method " + methodName + " Ends With " + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("The Method " + methodName + " Ends");
        return result;
    }
}

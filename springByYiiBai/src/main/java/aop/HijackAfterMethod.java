package aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-20 10:22
 * @Description: 返回后通知
 */
public class HijackAfterMethod implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("HijackAfterMethod: After method hijacked!");
    }
}

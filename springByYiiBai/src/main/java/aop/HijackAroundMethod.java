package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Arrays;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-20 11:17
 * @Description: 环绕通知
 */
public class HijackAroundMethod implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Method name: " + invocation.getMethod().getName());
        System.out.println("Method arguments: " + Arrays.toString(invocation.getArguments()));

        System.out.println("HijackAroundMethod: Before method hijacked!");
        Object result = invocation.proceed();
        System.out.println("HijackAroundMethod: Before after hijacked!");

        return result;
    }
}

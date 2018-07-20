package aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-20 10:15
 * @Description: 返回前通知
 */
public class HijackBeforeMethod implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("HijackBeforeMethod: Before method hijacked!");
    }
}

package proxyfactory;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 17:23
 * @Description: 模拟切面2
 */
public class LoggerBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("=====================保存更新日志===========================");
    }
}

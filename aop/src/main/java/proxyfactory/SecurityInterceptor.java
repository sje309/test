package proxyfactory;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 17:20
 * @Description: 模拟切面1
 */
public class SecurityInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("=================执行安全校验=================");
        return methodInvocation.proceed();
    }
}

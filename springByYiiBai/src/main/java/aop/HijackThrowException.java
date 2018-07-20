package aop;

import org.springframework.aop.ThrowsAdvice;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-20 10:51
 * @Description: 抛出后通知
 */
public class HijackThrowException implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException ex) throws Throwable {
        System.out.println("HijackThrowException: Throw exception hijacked!");
    }
}

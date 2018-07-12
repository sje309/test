package calclog;

import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-11 15:35
 * @Description:
 */
@Component("calculatorImpl")
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}

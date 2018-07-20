package spEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-19 13:42
 * @Description: EL表达式 运算符
 * 参考：https://www.yiibai.com/spring/spring-el-operators-example.html#article-start
 */
@Component(value = "eloperatorBean")
public class ElOperator {

    @Value("#{1 == 1}")
    private boolean testEqual;

    @Value("#{1 != 1}")
    private boolean testNotEqual;

    @Value("#{1 < 1}")
    private boolean testLessThan;

    @Value("#{1 <= 1}")
    private boolean testLessThanOrEqual;

    @Value("#{1 > 1}")
    private boolean testGreaterThan;

    @Value("#{1 >= 1}")
    private boolean testGreaterThanOrEqual;


    @Value("#{numberBean.no == 999 and numberBean.no < 900}")
    private boolean testAnd;

    @Value("#{numberBean.no == 999 or numberBean.no < 900}")
    private boolean testOr;

    @Value("#{!(numberBean.no == 999)}")
    private boolean testNot;

    //Mathematical operators

    @Value("#{1 + 1}")
    private double testAdd;

    @Value("#{'1' + '@' + '1'}")
    private String testAddString;

    @Value("#{1 - 1}")
    private double testSubtraction;

    @Value("#{1 * 1}")
    private double testMultiplication;

    @Value("#{10 / 2}")
    private double testDivision;

    @Value("#{10 % 10}")
    private double testModulus;

    @Value("#{2 ^ 2}")
    private double testExponentialPower;

    @Override
    public String toString() {
        return "Customer [testEqual=" + testEqual + ", testNotEqual="
                + testNotEqual + ", testLessThan=" + testLessThan
                + ", testLessThanOrEqual=" + testLessThanOrEqual
                + ", testGreaterThan=" + testGreaterThan
                + ", testGreaterThanOrEqual=" + testGreaterThanOrEqual
                + ", testAnd=" + testAnd + ", testOr=" + testOr + ", testNot="
                + testNot + ", testAdd=" + testAdd + ", testAddString="
                + testAddString + ", testSubtraction=" + testSubtraction
                + ", testMultiplication=" + testMultiplication
                + ", testDivision=" + testDivision + ", testModulus="
                + testModulus + ", testExponentialPower="
                + testExponentialPower + "]";
    }
}

package spEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-19 10:12
 * @Description: SpringEL方法调用和@Value注解
 * 参考：https://www.yiibai.com/spring/spring-el-method-invocation-example.html#article-start
 */
@Component(value = "customerBeanElCall")
public class CustomerELCall {
    @Value(value = "#{'shuyizhi'.toUpperCase()}")
    private String name;
    @Value(value = "#{priceBean.getSepicalPrice()}")
    private double amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CustomerELCall{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}

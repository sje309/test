package spEL;

import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-19 11:11
 * @Description:
 */
@Component(value = "priceBean")
public class Price {
    public double getSepicalPrice() {
        return new Double(199.09);
    }
}

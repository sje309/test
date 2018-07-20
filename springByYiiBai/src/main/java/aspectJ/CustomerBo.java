package aspectJ;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-20 14:10
 * @Description:
 */
public interface CustomerBo {
    void addCustomer();

    String addCustomerReturnValue();

    void addCustomerThrowException() throws Exception;

    void addCustomerAround(String name);
}

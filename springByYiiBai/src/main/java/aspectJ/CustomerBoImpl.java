package aspectJ;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-20 14:11
 * @Description:
 */
public class CustomerBoImpl implements CustomerBo {
    @Override
    public void addCustomer() {
        System.out.println("addCustomer() is running");
    }

    @Override
    public String addCustomerReturnValue() {
        System.out.println("addCustomerReturnValue() is running");
        return "abc";
    }

    @Override
    public void addCustomerThrowException() throws Exception {
        System.out.println("addCustomerThrowException() is running");
        throw new Exception("Generic Error");
    }

    @Override
    public void addCustomerAround(String name) {
        System.out.println("addCustomerAround() is running, args: " + name);
    }
}

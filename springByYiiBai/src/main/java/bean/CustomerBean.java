package bean;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-16 9:18
 * @Description: 内部Bean
 */
public class CustomerBean {
    private PersonBean personBean;

    public CustomerBean() {

    }

    public CustomerBean(PersonBean personBean) {
        this.personBean = personBean;
    }

    public void setPersonBean(PersonBean personBean) {
        this.personBean = personBean;
    }

    @Override
    public String toString() {
        return "Customer [person= " + personBean + " ]";
    }
}

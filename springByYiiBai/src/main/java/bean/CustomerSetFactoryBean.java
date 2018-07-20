package bean;

import java.util.Set;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-16 16:34
 * @Description: Spring SetFactoryBean实例
 * 参考：https://www.yiibai.com/spring/spring-setfactorybean-example.html#article-start
 */
public class CustomerSetFactoryBean {
    private Set sets;

    public Set getSets() {
        return sets;
    }

    public void setSets(Set sets) {
        this.sets = sets;
    }
}

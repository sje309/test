package bean;

import java.util.List;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-16 16:14
 * @Description: Spring Bean配置文件中创建一个具体的集合类(ArrayList和LinkedList)
 * 参考：https://www.yiibai.com/spring/spring-listfactorybean-example.html#article-start
 */
public class CustomerListFactoryBean {
    private List lists;

    public List getLists() {
        return lists;
    }

    public void setLists(List lists) {
        this.lists = lists;
    }
}

package bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-16 13:41
 * @Description: Spring 注入值到集合类型(List\Map\Set\Properties)
 * List ====> <list/>
 * Map =====> <map/>
 * Set =====> </set>
 * Properties =====> </props/>
 * 参考：https://www.yiibai.com/spring/spring-collections-list-set-map-and-properties-example.html#article-start
 */
public class CustomerListBeans {
    private List<Object> lists;
    private Set<Object> sets;
    private Map<Object, Object> maps;
    private Properties properties;

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Set<Object> getSets() {
        return sets;
    }

    public void setSets(Set<Object> sets) {
        this.sets = sets;
    }

    public Map<Object, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<Object, Object> maps) {
        this.maps = maps;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}

package spEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-19 14:30
 * @Description: SpringEL Lists,Maps实例
 * 参考：https://www.yiibai.com/spring/spring-el-lists-maps-example.html#article-start
 */
@Component(value = "elCollections")
public class ELCollections {
    @Value(value = "#{testBean.map['mapA']}")
    private String mapA;
    @Value(value = "#{testBean.List[0]}")
    private String list;

    public String getMapA() {
        return mapA;
    }

    public void setMapA(String mapA) {
        this.mapA = mapA;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ELCollections{" +
                "mapA='" + mapA + '\'' +
                ", list='" + list + '\'' +
                '}';
    }
}

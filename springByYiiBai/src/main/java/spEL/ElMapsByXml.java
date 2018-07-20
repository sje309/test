package spEL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-19 15:12
 * @Description: SpringEL List\Map操作 xml配置方式
 */
public class ElMapsByXml {
    private Map<String, String> map;
    private List<String> list;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public ElMapsByXml() {
        map = new HashMap<>();
        map.put("MapA", "This is MapA");
        map.put("MapB", "This is MapB");
        map.put("MapC", "This is MapC");

        list = new ArrayList<>();
        list.add("List0");
        list.add("List1");
        list.add("List2");
    }
}

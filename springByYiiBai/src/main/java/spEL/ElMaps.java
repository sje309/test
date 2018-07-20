package spEL;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-19 14:32
 * @Description:
 */
@Component(value = "testBean")
public class ElMaps {
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

    public ElMaps() {
        map = new HashMap<>();
        map.put("mapA", "This is MapA");
        map.put("mapB", "This is MapB");
        map.put("mapC", "This is MapC");

        list = new ArrayList<>();
        list.add("List0");
        list.add("List1");
        list.add("List2");


    }
}

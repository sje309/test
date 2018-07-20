package spEL;

/**
 * @Author: shuyizhi
 * @Date: 2018-07-19 15:13
 * @Description: SpringEL xml配置方式
 */
public class ELCollectionsByXml {
    private String mapA;
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
        return "ELCollectionsByXml{" +
                "mapA='" + mapA + '\'' +
                ", list='" + list + '\'' +
                '}';
    }
}

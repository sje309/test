package buildPattern;

/** @Author: shuyizhi @Date: 2018-10-11 15:44 @Description: 抽象接口，以规范产品对象的各个组成成分的建造 */
public interface PersonBuilder {
    void buildHead();

    void buildBody();

    void buildFoot();

    /**
     * 组装
     *
     * @return
     */
    Person buildPerson();
}

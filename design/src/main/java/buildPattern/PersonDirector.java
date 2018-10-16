package buildPattern;

/** @Author: shuyizhi @Date: 2018-10-11 16:51 @Description:Director 调用具体构造者来创建复杂对象的各个部分 */
public class PersonDirector {
    public Person contructorPerson(PersonBuilder builder) {
        /**按照 身体--->头部--->四肢 的顺序创建人物   */
        builder.buildHead();
        builder.buildBody();
        builder.buildFoot();

        return builder.buildPerson();
    }
}

package buildPattern;

/** @Author: shuyizhi @Date: 2018-10-11 15:48 @Description: */
public class ManBuilder implements PersonBuilder {
    public Person person;

    public ManBuilder() {
        person = new Person();
    }

    @Override
    public void buildHead() {
        person.setHead("buider header");
    }

    @Override
    public void buildBody() {
        person.setBody("buider body");
    }

    @Override
    public void buildFoot() {
        person.setFoot("buider foot");
    }

    @Override
    public Person buildPerson() {
        return person;
    }
}

package buildPattern;

/** @Author: shuyizhi @Date: 2018-10-11 16:53 @Description: */
public class TestBuilderPattern {
    public static void main(String[] args) {
        PersonDirector director = new PersonDirector();
        Person person = director.contructorPerson(new ManBuilder());

        System.out.println(person.getHead());
        System.out.println(person.getBody());
        System.out.println(person.getFoot());

    }
}

package rmi;

/**
 * @Author: shuyizhi
 * @Date: 2018/3/26 16:10
 * @Description:
 */
public class PersonServer {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonServer(String name,int age) {
        this.age = age;
        this.name = name;
    }
    public static void main(String[] args){
        // new object server
        PersonServer person = new PersonServer("Richard", 34);
        Person_Skeleton skel = new Person_Skeleton(person);
        skel.start();
    }
}

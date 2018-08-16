package stringtest;

/**
 * @Author: shuyizhi @Date: 2018-08-15 16:48 @Description: 浅拷贝与深拷贝
 * 参考：https://www.cnblogs.com/dolphin0520/p/3700693.html
 */
public class TestCopy {
    public static void main(String[] args) {
        testShallowCopy();
    }

    /** 浅复制 */
    public static void testShallowCopy() {

        Address address = new Address();
        address.setAddr("安徽合肥");

        Student stu1 = new Student();
        stu1.setNumber(12345);
        stu1.setAddress(address);

        Student stu2 = stu1;
        stu2.setNumber(54321);

        Student stu3 = null;
        try {
            stu3 = (Student) stu1.clone();
            stu3.setNumber(78945);
            Address address3 = new Address();
            address3.setAddr("安徽省合肥市高新区");
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("学生1学号: " + stu1.getNumber() + ",地址: " + stu1.getAddress().getAddr());
        System.out.println("学生2学号: " + stu2.getNumber() + ",地址: " + stu2.getAddress().getAddr());
        System.out.println("学生3学号: " + stu3.getNumber() + ",地址: " + stu3.getAddress().getAddr());

        System.out.println("stu1==stu2: " + (stu1 == stu2));
        System.out.println("stu1==stu3: " + (stu1 == stu3));
    }
}

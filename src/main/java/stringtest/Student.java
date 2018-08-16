package stringtest;

/** @Author: shuyizhi @Date: 2018-08-15 16:41 @Description:浅复制 shallow copy */
public class Student implements Cloneable {
    private int number;
    private Address address;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student stu = (Student) super.clone();
        return stu;
    }
}

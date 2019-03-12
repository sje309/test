package exception;

import org.junit.Test;

public class MyArrayTest {

    @Test
    public void getSize() {
        MyArray array = new MyArray(4);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        array.display();
        int i = array.get(1);
        System.out.println(i);
        array.delete(4);
        array.modify(3, 4);
        array.display();
    }

    @Test
    public void display() {}

    @Test
    public void add() {}

    @Test
    public void get() {}

    @Test
    public void find() {}

    @Test
    public void delete() {}

    @Test
    public void modify() {}
}

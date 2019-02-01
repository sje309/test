package exception;

public class MyArray {
    /** 定义一个数组 */
    private int[] intArray;
    /** 数组实际有效长度 */
    private int elems;
    /** 数组最大长度 */
    private int length;

    public MyArray() {
        elems = 0;
        length = 50;
        intArray = new int[length];
    }

    public MyArray(int length) {
        elems = 0;
        this.length = length;
        intArray = new int[length];
    }

    /**
     * 获取数组的有效长度
     *
     * @return
     */
    public int getSize() {
        return elems;
    }

    /** 循环遍历数组元素 */
    public void display() {
        for (int i = 0; i < elems; i++) {
            System.out.println(intArray[i] + " ");
        }
        System.out.println();
    }
    /** 添加数据 */
    public boolean add(int value) {
        if (elems == length) {
            return false;
        }
        intArray[elems] = value;
        elems++;
        return true;
    }

    /**
     * 获取指定下标的数组元素
     *
     * @param i
     * @return
     */
    public int get(int i) {
        if (i < 0 || i > elems) {
            throw new ArrayIndexOutOfBoundsException("数组下标越界");
        }
        return intArray[i];
    }

    /**
     * 查找元素,返回下标值，如果不存在，返回-1
     *
     * @param searchValue
     * @return
     */
    public int find(int searchValue) {
        int i;
        for (i = 0; i < elems; i++) {
            if (intArray[i] == searchValue) {
                break;
            }
        }
        if (i == elems) {
            return -1;
        }
        return i;
    }

    /**
     * 删除元素，如果要删除的值不存在，返回false,否则返回true
     *
     * @param value
     * @return
     */
    public boolean delete(int value) {
        boolean res = Boolean.FALSE;
        int k = find(value);
        if (k != -1) {
            for (int i = k; i < elems - 1; i++) {
                intArray[i] = intArray[i + 1];
            }
            elems--;
            res = Boolean.TRUE;
        }
        return res;
    }

    /**
     * 修改指定的数据
     *
     * @param oldValue 源数据
     * @param newValue 目的数据
     * @return
     */
    public boolean modify(int oldValue, int newValue) {
        int i = find(oldValue);
        boolean res = Boolean.FALSE;
        if (i == -1) {
            System.out.println("指定的数据不存在");
        } else {
            intArray[i] = newValue;
            res = Boolean.TRUE;
        }
        return res;
    }
}

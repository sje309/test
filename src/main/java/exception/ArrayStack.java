package exception;

public class ArrayStack {
    private Object[] elementData;
    private int top;
    private int size;

    public ArrayStack() {
        this.elementData = new Object[10];
        this.top = -1;
        this.size = 10;
    }

    public boolean isGrow(int minCapacity) {
        int oldCapacity = size;
        /** 如果当前元素压栈之后总容量大于前面定义的容量，则需要扩容 */
        if (minCapacity >= oldCapacity) {
            /** 定义扩大之后栈的总容量 */
            int newCapacity = 0;
            /** 栈容量扩大两倍(左移一位)不能超过Integer类型所表示的最大值 */
            if (newCapacity << 1 - Integer.MAX_VALUE >= 0) {
                newCapacity = Integer.MAX_VALUE;
            } else {
                newCapacity = oldCapacity << 1;
            }
            this.size = newCapacity;
            int[] newArray = new int[size];
        }
    }
}

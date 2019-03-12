package exception;

public class BubbleSort {
    /** 简单排序 */
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
            /** 第i轮排序后的结果为 */
            System.out.println(String.format("第%d轮排序后的结果为: ", i));
            display(array);
        }
        return array;
    }

    public static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 8, 9, 7, 6, 1, 3};
        System.out.println("未排序数组顺序为: ");
        display(array);
        array = sort(array);
        System.out.println("------------------------------------");
        System.out.println("冒泡排序后的数组顺序为: ");
        display(array);
    }
}

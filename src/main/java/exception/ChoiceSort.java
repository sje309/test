package exception;

/** 选择排序 */
public class ChoiceSort {

    public static int[] sort(int[] array) {
        /** 总共要经过N-1轮比较 */
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            /** 每轮需要比较的次数 */
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    /** 记录目前能找到的最小值元素的下标 */
                    min = j;
                }
            }
            /** 将找到的最小值和i位置所在的值进行交换 */
            if (i != min) {
                int tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
            /** 第i轮排序的结果 */
            System.out.print(String.format("第%d轮排序的结果为: ", (i + 1)));
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
        System.out.println("选择排序后的数组顺序为: ");
        display(array);
    }
}

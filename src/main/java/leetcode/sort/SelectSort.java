package leetcode.sort;

/**
 * Created by wangxiang on 2022/2/19
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] data = {7, 16, 23, 42, 30, 1, 9, 5, 6, 55, 2, 3, 3};

        selectSort(data);
    }

    static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];

            int minIndex = i;
            //找出剩余元素中最小的
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[minIndex] > arr[j + 1]) {
                    minIndex = j + 1;
                }
            }

            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

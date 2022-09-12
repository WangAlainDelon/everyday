package leetcode.sort;

/**
 * Created by wangxiang on 2022/2/19
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] data = {7, 16, 23, 42, 30, 1, 9, 5, 6, 55, 2, 3, 3};
        binaryInsertionSort(data);
        insertionSort(data);
    }


    /**
     * 普通的插入排序
     *
     * @param arr
     */
    static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * 折半插入排序
     *
     * @param arr
     */
    static void binaryInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int left = 0;
            int right = i;  // 1

            while (left < right) {
                int mid = (left + right) >> 1;  // 0
                if (arr[i] <= arr[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int temp = arr[i];
            //找到合适的插入位置，数组就从插入的位置开始移动
            for (int j = i; j > left; j--) {
                arr[j] = arr[j - 1];
            }
            arr[left] = temp;
        }
    }
}

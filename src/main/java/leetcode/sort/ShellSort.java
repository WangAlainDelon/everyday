package leetcode.sort;

/**
 * Created by wangxiang on 2022/2/20
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] data = {7, 16, 23, 42, 30, 1, 9, 5, 6, 55, 2, 3, 3};
//        int[] data={2,6,4,3,9,5};
        shellSort(data);
    }

    static void shellSort(int[] arr) {
        int increment = (arr.length >> 1);
        for (int i = increment; i > 0; i--) {  // 步长 >0
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + i]) {
                    int temp = arr[j];
                    arr[j] = arr[i + j];
                    arr[i + j] = temp;
                }
            }
        }
    }
}

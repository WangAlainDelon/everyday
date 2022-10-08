package leetcode.array.leetcode5_75;

public class CountSort {

    //时间复杂度O(n)
    //空间复杂度 O(1)
    static void countSort(int[] arr) {
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zero++;
            }
            if (arr[i] == 1) {
                one++;
            }
            if (arr[i] == 2) {
                two++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i < zero) {
                arr[i] = 0;
            }
            if (i >= zero && i < (zero + one)) {
                arr[i] = 1;
            }
            if (i >= (zero + one)) {
                arr[i] = 2;
            }
        }
    }
}

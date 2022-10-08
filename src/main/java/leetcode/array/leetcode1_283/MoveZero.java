package leetcode.array.leetcode1_283;

public class MoveZero {
    //移除数组中的0元素   将0元素和非零元素分开，非零元素相对位置不变
    public static void main(String[] args) {

    }

    // O(n^2)
    //
    static void moveZero(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] == 0) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // O(n)
    static void moveZero2(int[] arr) {
        int flagNonZero = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] != 0) {
                arr[flagNonZero] = arr[i];
                flagNonZero++;
            }
        }
        for (int i = arr.length - 1; i >= flagNonZero; i--) {
            arr[i] = 0;
        }
    }


}

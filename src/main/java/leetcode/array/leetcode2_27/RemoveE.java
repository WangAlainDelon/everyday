package leetcode.array.leetcode2_27;

public class RemoveE {

    //删除数组中指定的元素
    public static void main(String[] args) {

    }


    //时间复杂度O(n)
    //空间复杂度O（1）
    static void removeE(int[] arr, int e) {

        int flagNoNe = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != e) {
                arr[flagNoNe] = arr[i];
                flagNoNe++;
            }
        }
        for (int i = arr.length - 1; i >= flagNoNe; i--) {
            arr[i] = 0;
        }
    }



}

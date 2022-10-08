package leetcode.array.leetcode3_26;

public class RemoveDuplicates {
    //删除重复的元素
    public static void main(String[] args) {

    }

    //时间复杂度O（n）
    //空间复杂度O(1)
    public int removeDuplicates(int[] arr) {
        int i = 0;
        int j = 1;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            } else {
                arr[i + 1] = arr[j];
                i++;
                j++;
            }
        }
        return i + 1;
    }
}

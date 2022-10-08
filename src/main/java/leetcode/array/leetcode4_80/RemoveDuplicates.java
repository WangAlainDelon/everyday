package leetcode.array.leetcode4_80;

public class RemoveDuplicates {

    //删除重复的元素  要求重复的元素保留两个

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] arr) {
        if (arr.length <= 2) {
            return arr.length;
        }

        int i = 0;
        int j = 2;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            } else {
                arr[i + 2] = arr[j];
                i++;
                j++;

            }
        }
        return i + 2;
    }

}

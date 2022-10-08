package leetcode.array.leetcode6_88;

public class MergeArray {

    //合并两个有序数组
    public static void main(String[] args) {

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int s1 = 0;   //nums1数组的起始下标
        int s2 = 0;   //nums2数组的起始下标
        int[] temp = new int[m + n];
        int i = 0; //临时数组的起始下标
        //合并的话两个数组必须都有元素才行
        while (s1 < m && s2 < n) {
            if (nums1[s1] >= nums2[s2]) {
                temp[i] = nums2[s2];
                i++;
                s2++;
            } else {
                temp[i] = nums1[s1];
                s1++;
                i++;
            }
        }
        //nums1还有元素
        while (s1 < m) {
            temp[i] = nums1[s1];
            s1++;
            i++;
        }

        while (s2 < n) {
            temp[i] = nums2[s2];
            s2++;
            i++;
        }
        //把临时数组放到nums1
        for (int j = 0; j < temp.length; j++) {
            nums1[j] = temp[j];
        }
    }
}

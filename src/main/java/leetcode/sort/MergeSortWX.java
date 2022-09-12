package leetcode.sort;

/**
 * Created by wangxiang on 2022/2/22
 */
public class MergeSortWX {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge1(nums1, m, nums2, n);


        int[] data = {7, 16, 23, 42, 30, 1, 9, 5, 6, 55, 2, 3, 3};

        mergeSort(data, 0, data.length - 1);


    }


    static void mergeSort(int[] arr, int low, int high) {
        //采用分治的思想，先分
        if (low >= high) {
            return;
        }
        int mid = (low + high) >>> 1;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        //分完之后就开始和，合并的条件就是
        merge(arr, low, high, mid);
    }

    private static void merge(int[] arr, int low, int high, int mid) {
        //将两个归并集合进行合并，首先需要保证的是归并集合钟有元素
        int s1 = low;  //第一个归并集合的起始序列
        int s2 = mid + 1;  //四二个归并集合的起始序列

        //归并两个集合后的临时数组
        int[] tempArr = new int[high - low + 1];
        int i = 0;//临时数组的初始下标

        //保证两个归并集合必须有元素才能合并
        while (s1 <= mid && s2 <= high) {
            //从两个归并集合的第一个元素开始比较，谁小谁排前面
            if (arr[s1] >= arr[s2]) {
                tempArr[i] = arr[s2];
                //将小的拉下后小的归并段下标加1
                s2++;
                i++;
            } else {
                tempArr[i] = arr[s1];
                s1++;
                i++;
            }
        }
        //当其中一个归并段先排完时，把剩下的归并段直接填到临时数组
        while (s1 <= mid) {
            tempArr[i] = arr[s1];
            i++;
            s1++;
        }
        while (s2 <= high) {
            tempArr[i] = arr[s2];
            i++;
            s2++;
        }

        //最后一步就是将临时数组拷贝到原数组的位置
        for (int j = low; j <= high; j++) {
            arr[j] = tempArr[j - low];
        }

    }


    public static void merge1(int[] nums1, int m, int[] nums2, int n) {

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

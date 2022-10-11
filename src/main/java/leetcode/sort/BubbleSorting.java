package leetcode.sort;

/**
 * Created by wangxiang on 2022/1/18
 */
public class BubbleSorting {
    static {}
    static {}

    public static void main(String[] args) {

        //n个元素进行冒泡排序最多n-1趟

        //循环了多少次
        int a = 0;
        int b = 0;

        int[] nums = {2, 0, 2, 1, 1, 0};


//        bubbleSorting(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            a++;
            for (int j = 0; j < nums.length - 1; j++) {
                b++;
                if (nums[j] > nums[j + 1]) {
                    int num = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = num;
                }
            }

        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    /**
     * 外层循环是比较的趟数  hasChange表示是否发生元素的交换，如果比较一趟没有发生元素的交换则数组已经排好序
     * 每一趟排好最大的一个数
     *
     * @param arr
     */
    static void bubbleSorting(int[] arr) {
        boolean hasChange = true;
        for (int i = 0, n = arr.length; i < n && hasChange; i++) {
            hasChange = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    hasChange = true;
                }
            }
        }

    }


}

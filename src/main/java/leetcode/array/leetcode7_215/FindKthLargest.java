package leetcode.array.leetcode7_215;

public class FindKthLargest {
    //在一个整数序列中寻找第K大的元素


    /**
     * Created by wangxiang on 2022/2/26
     */

    public static void main(String[] args) {
        int[] data = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = findKthLargest(data, k);

    }

    public static int findKthLargest(int[] nums, int k) {

        int low = 0;
        int high = nums.length - 1;

        int pos = nums.length - k;

        while (true) {
            int index = partition(nums, low, high);
            if (index == pos) {
                return nums[index];
            } else if (index < pos) {
                low = index + 1;
            } else {
                high = index - 1;
            }
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high;
        int base = nums[low];
        while (i != j) {
            while (nums[j] >= base && i < j) {
                j--;
            }
            while (nums[i] <= base && i < j) {
                i++;
            }
            int temp;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        //排出第几个元素
        nums[low] = nums[i];
        nums[i] = base;
        return i;
    }

}

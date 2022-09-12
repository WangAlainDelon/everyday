package leetcode.sort;

/**
 * Created by wangxiang on 2022/2/26
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] data = {3, 2, 1, 5, 6, 4};
        int low = 0;
        int high = data.length - 1;

//        findKthLargest(data, 2);


        quickSort(data, low, high);

    }

    static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        //
        int i = low;
        int j = high;
        int base = arr[i];
        while (i != j) {
            //从右开始检索，如果小于基准，则停下
            while (arr[j] >= base && i < j) {
                j--;
            }
            //从左往右检索，如果大于基准则停下
            while (arr[i] <= base && i < j) {
                i++;
            }
            //走到这里，说明low和high都停下了，交换两个的位置
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //走到这里说明两者相遇了，这个时候就要交换基准的位置
        arr[low] = arr[i];
        arr[i] = base;
        //交换完基准以后数组被分为左右两边，递归处理左边
        quickSort(arr, low, i - 1);
        //递归处理右边
        quickSort(arr, j + 1, high);
    }


//    public static int findKthLargest(int[] nums, int k) {
//
//        int low = 0;
//        int high = nums.length - 1;
//
//        test(nums, low, high, k);
//
//    }

    private static void test(int[] nums, int low, int high, int k) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int base = nums[high - k];
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
//        int test = test(nums, low, i - 1, k, v);
//        int test1 = test(nums, j + 1, high, k, v);
//        return test1;

    }
}

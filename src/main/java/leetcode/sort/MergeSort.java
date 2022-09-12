package leetcode.sort;

/**
 * Created by wangxiang on 2022/2/19
 */
public class MergeSort<K, V> {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 4, 5, 3};

        mergeSort(nums);
    }

    private static void mergeSort(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        mergeSort(nums, 0, n - 1, temp);
    }

    private static void mergeSort(int[] nums, int low, int high, int[] temp) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) >>> 1;
        mergeSort(nums, low, mid, temp);
        mergeSort(nums, mid + 1, high, temp);
        merge(nums, low, mid, high, temp);
    }

    private static void merge(int[] nums, int low, int mid, int high, int[] temp) {
        int i = low, j = mid + 1, k = low;
        while (k <= high) {
            if (i > mid) {
                temp[k++] = nums[j++];
            } else if (j > high) {
                temp[k++] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        //从数组temp范围为low到high + 1 中取出high - low + 1个元素，放到数组nums中的low 到high + 1中
        System.arraycopy(temp, low, nums, low, high - low + 1);
    }

    public K put(K key, V value) {
        return null;
    }
}

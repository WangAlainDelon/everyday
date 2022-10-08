package leetcode.array.leetcode13_209;

public class MinSubArrayLen {

    public static void main(String[] args) {
        //返回满足条件的最长连续子数组
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int re = nums.length + 1;
        int sum = nums[0];
        while (i <= j && j <= nums.length - 1) {
            if (sum >= target) {
                int temp = j - i + 1;
                if (temp < re) {
                    re = temp;
                }
                sum = sum - nums[i];
                i++;

            } else {
                j++;
                if (j <= nums.length - 1) {
                    sum = sum + nums[j];
                }
            }
        }
        return re == (nums.length + 1) ? 0 : re;
    }
}

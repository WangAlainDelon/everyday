package leetcode.dynamic.programming.leetcode1_70;

public class ClimbStairs {

    /**
     * 爬楼梯 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     **/
    public static void main(String[] args) {

        int i = climbStairs2(3);
    }

    // 3=1+1+1  3=2+1 3=1+2   通过归纳法可以得到 F（n）=F（n-1）+F（n-2） 的规律
    // O（n2） 时间复杂度是n的平方
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    /**
     * 记忆化搜索法  去除重复的计算， 将时间复杂度优化到O（n）
     */
    public static int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return subClimbStairs2(n, memo);
    }

    private static int subClimbStairs2(int n, int[] memo) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 1) {
            memo[n] = 1;
        } else if (n == 2) {
            memo[n] = 2;
        } else {
            memo[n] = subClimbStairs2(n - 1, memo) + subClimbStairs2(n - 2, memo);
        }
        return memo[n];
    }

    //转化为动态规划
    public int climbStairs3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}

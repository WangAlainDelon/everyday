package leetcode.dynamic.programming.leetcode1_70;

public class ClimbStairs {

    /**
     * 爬楼梯 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     **/
    public static void main(String[] args) {

    }

    // 3=1+1+1  3=2+1 3=2+1
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return 0;
    }
}

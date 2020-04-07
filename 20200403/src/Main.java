import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/7f24eb7266ce4b0792ce8721d6259800
 * 来源：牛客网
 *
 * 给定一个有n个正整数的数组A和一个整数sum,求选择数组A中部分数字和为sum的方案数。
 * 当两种选取方案有一个数字的下标不一样,我们就认为是不同的组成方案。
 *
 * 输入描述:
 * 输入为两行:
 *  第一行为两个正整数n(1 ≤ n ≤ 1000)，sum(1 ≤ sum ≤ 1000)
 *  第二行为n个正整数A[i](32位整数)，以空格隔开。
 *
 * 输出描述:
 * 输出所求的方案数
 * 示例1
 * 输入
 * 5 15 5 5 10 2 3
 * 输出
 * 4
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(bag(arr,n,sum));
        }
    }

    //背包问题
    private static long bag(int[] arr, int n, int sum) {
        long dp[] = new long[sum+1];
        dp[0] = 1;
        for (int i = 0;i < n;i++){
            for (int j = sum;j >= arr[i];j--){
                dp[j] = dp[j-arr[i]] + dp[j];//放入物品i和不放入物品i的方法总和
            }
        }
        return dp[sum];
    }
}

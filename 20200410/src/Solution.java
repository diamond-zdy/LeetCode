public class Solution {
    /**风口的猪-中国牛市
     * 链接：https://www.nowcoder.com/questionTerminal/9370d298b8894f48b523931d40a9a4aa
     * 来源：牛客网
     *
     * 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
     * 示例1
     * 输入
     * 3,8,5,1,7,8
     * 输出
     * 12
     *
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    public static int calculateMax(int[] prices) {
        int FirstBuy = Integer.MAX_VALUE;
        int FirstAfter = 0;
        int SecondBuy = Integer.MIN_VALUE;
        int SecondAfter = 0;
        for (int cur:prices) {
            FirstBuy = Math.min(FirstBuy,cur);
            FirstAfter = Math.max(FirstAfter,cur-FirstBuy);
            SecondBuy = Math.max(SecondBuy,FirstAfter-cur);
            SecondAfter = Math.max(SecondAfter,cur+SecondBuy);
        }
        return SecondAfter;
    }

    public static void main(String[] args) {
        int[] prices = {3,8,5,1,7,8};
        System.out.println(calculateMax(prices));
    }
}
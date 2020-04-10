import java.util.Scanner;

/**在霍格罗茨找零钱
 * 链接：https://www.nowcoder.com/questionTerminal/58e7779c9f4e413cb80792d33ba6acaf
 * 来源：牛客网
 *
 * 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，
 * 二十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
 *
 * 输入描述:
 * 输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。这里Galleon是[0, 107]]区间内的整数，Sickle是[0,
 * 17)区间内的整数，Knut是[0, 29)区间内的整数。
 *
 *
 * 输出描述:
 * 在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
 * 示例1
 * 输入
 * 10.16.27 14.1.28
 * 输出
 * 3.2.1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] str1 = sc.next().split("\\.");
            String[] str2 = sc.next().split("\\.");
            int[] w = {17*29,29,1};
            int[] P = {Integer.parseInt(str1[0]),Integer.parseInt(str1[1]),Integer.parseInt(str1[2])};
            int[] A = {Integer.parseInt(str2[0]),Integer.parseInt(str2[1]),Integer.parseInt(str2[2])};
            int p1 = P[0]*w[0] + P[1] * w[1] + P[2] * w[2];
            int a1 = A[0]*w[0] + A[1] * w[1] + A[2] * w[2];
            int res = a1-p1;
            if(a1 < p1){
                System.out.print("-");
                res = -res;
            }
            System.out.println(res/w[0] + "." + res%w[0]/w[1] + "." + res%w[0]%w[1]/w[2]);
        }
    }
}

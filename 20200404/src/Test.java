import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**大整数排序
 * 链接：https://www.nowcoder.com/questionTerminal/b744af632ac4499aa485d7bb048bb0aa
 * 来源：牛客网
 *
 * 对N个长度最长可达到1000的数进行排序。
 *
 * 输入描述:
 * 输入第一行为一个整数N，(1<=N<=100)。
 * 接下来的N行每行有一个数，数的长度范围为1<=len<=1000。
 * 每个数都是一个正数，并且保证不包含前缀零。
 *
 * 输出描述:
 * 可能有多组测试数据，对于每组数据，将给出的N个数从小到大进行排序，输出排序后的结果，每个数占一行。
 * 示例1
 * 输入
 * 3
 * 11111111111111111111111111111
 * 2222222222222222222222222222222222
 * 33333333
 * 输出
 * 33333333
 * 11111111111111111111111111111
 * 2222222222222222222222222222222222
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            BigInteger[] bg = new BigInteger[N];
            for (int i = 0;i < N;i++){
                bg[i] = sc.nextBigInteger();
            }
            Arrays.sort(bg);
            for (int i = 0;i < N;i++){
                System.out.println(bg[i]);
            }
        }
    }
}

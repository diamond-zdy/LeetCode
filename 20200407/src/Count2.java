import java.util.*;

/**2的个数
 * 请编写一个方法，输出0到n(包括n)中数字2出现了几次。
 *
 * 给定一个正整数n，请返回0到n的数字中2出现了几次。
 *
 * 测试样例：
 * 10
 * 返回：1
 */
public class Count2 {
    /*超时
    public static int countNumberOf2s(int n){
        int count = 0;
        int i = 0;
        if (n < 2){
            return 0;
        }else if (n <= 10){
            return 1;
        }
        else {
            for (int j = 2;j <= n;j++){
                i = j;
                while (i > 0){
                    if (i % 10 == 2){
                        count++;
                        i /= 10;
                    }
                    if (i == 0){
                        break;
                    }
                }
            }
        }
        return count;
    }*/

    public static int countNumberOf2s(int n) {
        int count = 0;
        for (int i = 1; i <= n; i *= 10) {
            int a = n / i,b = n % i;
            //之所以补8，是因为当百位为0，则a/10==(a+8)/10，
            //当百位>=2，补8会产生进位位，效果等同于(a/10+1)
            count += (a + 7) / 10 * i + ((a % 10 == 2) ? b + 1 : 0);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countNumberOf2s(12));
    }
}
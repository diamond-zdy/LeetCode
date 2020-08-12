import java.util.*;
/*
给定一个仅由大写字母组成的字符串以及一个指定的奇列数，按从左到右，从上到下的顺序将给定的字符串一大X字形排列成指定的列数
例如，ABCDEF，3
A   B
  C
D   E
  F
然后从上到下逐列读取上面的X字形排列产生一个新字符串，如：ADCFBE
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        int[][] arr = new int[2][n];
        int count = -1;
        for (int i = 0; i <= n/2; i++) {
            arr[0][i] = count + 2;
            count += 2;
        }
        count = n + 1;
        for (int i = n/2 + 1; i < n; i++) {
            arr[0][i] = count - 2;
            count -= 2;
        }
        count = 2 * n - 2;
        for (int i = 1; i < n/2; i++) {
            arr[1][i] = count - 2;
            count -= 2;
        }
        count = n;
        for (int i = n/2 + 1; i < n - 1; i++) {
            arr[1][i] = count + 2;
            count += 2;
        }
        for (int i = 0; i < n; i++) {
            int x = arr[0][i];
            int y = arr[1][i];
            if(y != 0 && y != n){
                while (y - 1< str.length() || x - 1< str.length()){
                    if(x - 1< str.length()){
                        System.out.print(str.charAt(x - 1));
                        x += 2 * n - 3;
                    }
                    if(y - 1< str.length() ){
                        System.out.print(str.charAt(y - 1));
                        y += 2 * n - 3;
                    }
                }
            }else {
                while (x - 1< str.length()){
                    System.out.print(str.charAt(x - 1));
                    x += 2 * n - 3;
                }
            }
        }
    }
}
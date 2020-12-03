import java.util.Scanner;
//求末尾0的个数
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for (int i = 5;i <= n;i *= 5){
            res += n/i;
        }
        System.out.println(res);
    }
}

import java.util.Scanner;
//末尾0的个数
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = 5;i <= n;i*=5){
            res += n / i;
        }
        System.out.println(res);
    }
}

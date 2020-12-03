import java.util.Scanner;
/*给定一个数 求出把这个数变成斐波那契数的最小步数*/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0;
        int b = 0;
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        if (n > 1){
            for (int i = 2;i < n;i++){
                arr[i] = arr[i-1] + arr[i-2];
                if (arr[i]>=n){
                    b = arr[i];
                    a = arr[i-1];
                    break;
                }
            }
        }
        int a1 = n-a;
        int b1 = b-n;
        if (n == 0 || n == 1){
            System.out.println(0);
        }else{
            System.out.println(a1 < b1 ? a1 : b1);
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int a = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            for (int i = 0;i < n;i++){
                if (arr[i] <= a){
                    a += arr[i];
                }else {
                    a += common(a,arr[i]);
                }
            }
            System.out.println(a);
        }
    }
    public static int common(int a,int b){
        int count = 1;
        for (int i = a;i > 1;i--){
            if (a%i==0 && b%i==0){
                count = i;
                break;
            }
        }
        return count;
    }
}

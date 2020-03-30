import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = {0,0,0,0,0};
        int count = 0;
        int count2 = 0;
        for (int i = 0;i < n;i++){
            a[i] = sc.nextInt();
            if (a[i] % 10 == 0){
                b[0] += a[i];
            }else if (a[i] % 5 == 1){
                b[1] += Math.pow(-1,count)*a[i];
                count++;
            }else if (a[i] % 5 == 2){
                b[2]++;
            }else if (a[i] % 5 == 3){
                b[3] += a[i];
                count2++;
            }else {
                if (b[4] < a[i]){
                    b[4] = a[i];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        String str = String.format("%.1f",(float)b[3]/(float)count2);
        for (int i = 0;i < 5;i++){
            if (b[i] == 0){
                sb.append("N ");
            }else if (i == 3){
                sb.append(str + " ");
            }else {
                sb.append(b[i] + " ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}

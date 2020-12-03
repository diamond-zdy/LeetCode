import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        int[] num = new int[str.length-1];
        for (int i = 0;i < num.length;i++){
            num[i] = Integer.parseInt(str[i]);
        }
        int k = Integer.parseInt(str[str.length-1]);
        Arrays.sort(num);
        for (int i = 0;i < k;i++){
            System.out.print(i == k-1 ? num[i] : num[i]+" ");
        }
    }
}

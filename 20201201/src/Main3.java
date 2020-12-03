import java.util.Scanner;
//数字逆序列
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuffer sb = new StringBuffer();
        String s = String.valueOf(n);
        for (int i = s.length()-1;i >= 0;i--){
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }
}

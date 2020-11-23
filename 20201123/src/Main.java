import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int res = 0;
        int len = a.length();
        for (int i = 0;i < len;i++){
            StringBuffer sb = new StringBuffer(a);
            sb.insert(i,b);
            if (hui(sb)){
                res++;
            }
        }
        System.out.println(res);
    }

    private static boolean hui(StringBuffer sb) {
        boolean flg = false;
        int left = 0;
        int right = sb.length()-1;
        while (right >= left){
            if (sb.charAt(left) == sb.charAt(right)){
                left++;
                right--;
            }else {
                break;
            }
        }
        if (left < right){
            flg = false;
        }else {
            flg = true;
        }
        return flg;
    }
}

import java.util.Scanner;
//第一行输入一串字符串，第二行输入一个数字x，输出第一行字符串删掉x个数字后最小的字符串
//例：输入：1432319
//3
//输出：1219
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int x = sc.nextInt();
        String res = minN(str,x);
        System.out.println(res);
    }
    public static String minN(String str,int x){
        if (str == null || ("").equals(str) || ("").equals(str.trim()) || x == 0){
            return str;
        }
        if (str.length() <= x){
            return "0";
        }
        StringBuffer sb = new StringBuffer(str);
        while (x > 0){
            int i = 0;
            while (sb.length()-1 > i && sb.charAt(i) <= sb.charAt(i+1)){
                i++;
            }
            sb.delete(i,i+1);
            x--;
        }
        while (sb.length() != 0 && sb.charAt(0) == '0'){
            sb.delete(0,1);
            if (sb.length() == 0){
                return "0";
            }
        }
        return sb.toString();
    }
}

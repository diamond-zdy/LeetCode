import java.util.Scanner;
/*删除公共字符*/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String s = "[" + str2 + "]";
        String res = str1.replaceAll(s,"");
        System.out.println(res);
    }
}

import java.util.Scanner;
//删除公共字符
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s = "[" + s2 + "]";
        System.out.println(s1.replaceAll(s,""));
    }
}

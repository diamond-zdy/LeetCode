import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String tmp = "[" + str2 + "]";
            String res = str1.replaceAll(tmp,"");
            System.out.println(res);
        }
    }
}

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//找不同
//给定一个字符串S1，S2是S1乱序排好再添加了一个字母，求添加的那个字母
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        Set<Character> set = new HashSet<>();
        char[] ch = s1.toCharArray();
        for (int i = 0;i < ch.length;i++){
            set.add(ch[i]);
        }
        for (int i = 0;i < s2.length();i++){
            if (!set.contains(s2.charAt(i))){
                System.out.println(s2.charAt(i));
                break;
            }
        }
    }
}

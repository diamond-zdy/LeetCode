import java.util.Scanner;

/**broken keyboard
 * 链接：https://www.nowcoder.com/questionTerminal/b24930625eb24a159f25bca43814e50d
 * 来源：牛客网
 *
 * On a broken keyboard, some of the keys are worn out. So when you type some sentences, the characters
 * corresponding to those keys will not appear on screen.
 *
 * Now given a string that you are supposed to type, and the string that you actually type out, please list those keys
 * which are for sure worn out.
 *
 * 输入描述:
 * Each input file contains one test case. For each case, the 1st line contains the original string, and the 2nd line contains the typed-out string. Each string contains
 * no more than 80 characters which are either English letters [A-Z] (case
 * insensitive), digital numbers [0-9], or "_" (representing the space). It is guaranteed that both strings are non-empty.
 *
 *
 * 输出描述:
 * For each test case, print in one line the keys that are worn out, in the order of being detected. The English letters must be capitalized.
 * Each worn out key must be printed once only. It is guaranteed that there is at least one worn out key.
 * 示例1
 * 输入
 * 7_This_is_a_test<br/>_hs_s_a_es
 * 输出
 * 7TI
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            str1 = str1.toUpperCase();
            str2 = str2.toUpperCase();
            for (int i = 0;i < str2.length();i++){
                str1 = str1.replace(str2.charAt(i)+"","");
            }
            String res = "";
            for (int i = 0;i < str1.length();i++){
                if (res.contains(str1.charAt(i)+"")){
                    continue;
                }else {
                    System.out.print(str1.charAt(i));
                    res += str1.charAt(i);
                }
            }
        }
    }
}

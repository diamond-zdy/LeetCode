import java.util.ArrayList;
import java.util.Scanner;

/**乒乓球筐
 * 链接：https://www.nowcoder.com/questionTerminal/bb4f1a23dbb84fd7b77be1fbe9eaaf32?orderByHotValue=1&done=0&pos=10&mutiTagIds=589&onlyReference=false
 * 来源：牛客网
 *
 * nowcoder有两盒（A、B）乒乓球，有红双喜的、有亚力亚的……现在他需要判别A盒是否包含了B盒中所有的种类，并且每种球的数量不少于B盒中的数量，该怎么办呢？
 *
 * 输入描述:
 * 输入有多组数据。
 * 每组数据包含两个字符串A、B，代表A盒与B盒中的乒乓球，每个乒乓球用一个大写字母表示，即相同类型的乒乓球为相同的大写字母。
 * 字符串长度不大于10000。
 *
 *
 * 输出描述:
 * 每一组输入对应一行输出：如果B盒中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出“Yes”；否则输出“No”。
 * 示例1
 * 输入
 * ABCDFYE CDE<br/>ABCDGEAS CDECDE
 * 输出
 * Yes<br/>No
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] s = str.split(" ");
            ArrayList<Character> A = new ArrayList<Character>();
            ArrayList<Character> B = new ArrayList<Character>();
            for (int i = 0;i < s[0].length();i++){
                A.add(s[0].charAt(i));
            }
            for (int i = 0;i < s[1].length();i++){
                B.add(s[1].charAt(i));
            }
            for (int i = 0;i < B.size();i++){
                if (A.contains(B.get(i))){
                    A.remove(A.get(A.indexOf(B.get(i))));
                    B.remove(i);
                    i--;
                }
            }
            if (B.size() == 0){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}

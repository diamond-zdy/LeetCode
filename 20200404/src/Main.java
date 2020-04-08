import java.util.Scanner;

/**奇偶校验
 * 输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数(如'3’，输出：10110011)。
 * 输入描述:
 * 输入包括一个字符串，字符串长度不超过100。
 * 输出描述:
 * 可能有多组测试数据，对于每组数据，
 * 对于字符串中的每一个字符，输出按题目进行奇偶校验后的数，每个字符校验的结果占一行。
 * 示例1
 * 输入
 * 复制
 * 3
 * 3a
 * 输出
 * 复制
 * 10110011
 * 10110011
 * 01100001
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] ch = str.toCharArray();
            for (char c:ch) {
                String s1 = Integer.toBinaryString(c);
                String s2 = String.format("%07d",Integer.parseInt(s1));
                int count = 0;
                for (int i = 0;i < 7;i++){
                    if (s2.charAt(i) == '1'){
                        count++;
                    }
                }
                System.out.println(count%2 == 1 ? "0"+s2 : "1" + s2);
            }
        }
    }
}

import java.util.Scanner;

/**回文串
 * 链接：https://www.nowcoder.com/questionTerminal/655a43d702cd466093022383c24a38bf?f=discussion
 * 来源：牛客网
 *
 * 给定一个字符串，问是否能通过添加一个字母将其变为回文串。
 *
 * 输入描述:
 * 一行一个由小写字母构成的字符串，字符串长度小于等于10。
 *
 *
 * 输出描述:
 * 输出答案(YES\NO).
 * 示例1
 * 输入
 * coco
 * 输出
 * YES
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(isAns(s.toCharArray(),0,s.length()-1,false) == true ? "YES" :"NO");
        }
    }

    private static boolean isAns(char[] chars, int start, int end, boolean b) {
        if (start >= end){
            return true;
        }
        if (chars[start] == chars[end]){
            return isAns(chars,start+1,end-1,true);
        }else {
            if (b){
                return false;
            }else {
                return isAns(chars,start+1,end,true) || isAns(chars,start,end-1,true);
            }
        }
    }
}

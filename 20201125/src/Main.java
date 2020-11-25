import java.util.Scanner;
/*求最长数字串
给定一个字符串，找出最长的数字串*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < str.length();i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                sb.append(str.charAt(i));
            }else {
                sb.append('a');
            }
        }
        String s1 = sb.toString();
        String[] strings = s1.split("a");
        int count = 0;
        for (int i = 0;i < strings.length;i++){
            if (count < strings[i].length()){
                count = strings[i].length();
            }
        }
        for (int i = 0;i < strings.length;i++){
            if (strings[i].length() == count){
                System.out.println(strings[i]);
            }
        }
    }
}

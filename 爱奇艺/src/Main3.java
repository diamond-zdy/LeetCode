//合法的括号
import java.util.Scanner;
import java.util.Stack;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        int n = s.length();
        int tmp = n/2;
        boolean flg = true;
        if (n % 2 ==1){
            flg = false;
        }
        for (int i = 0;i < n/2;i++){
            if (s.charAt(i) == '('){
                stack.push(')');
            }else if (s.charAt(i) == '['){
                stack.push(']');
            }else if (s.charAt(i) == '{'){
                stack.push('}');
            }else {
                flg = false;
            }
        }
        while (!stack.empty()){
            if (s.charAt(tmp) != stack.pop()){
                flg = false;
            }
            tmp++;
        }

        if (flg){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }
}

import java.util.*;
/*合法括号判断：
给定一个字符串 判断字符串是否合法，只有‘（’；
例：（（））（） 合法*/
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        if (n % 2 == 1){
            return false;
        }
        boolean flg = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < n;i++){
            if (A.charAt(i) == '('){
                stack.push(')');
            }else if (!stack.isEmpty() && A.charAt(i) == ')'){
                stack.pop();
            }else {
                return false;
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
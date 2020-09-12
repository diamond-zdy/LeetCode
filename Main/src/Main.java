import java.util.Scanner;
//知道二叉树的中序和后序遍历，求前序遍历
public class Main {
    public static String res = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        preTree(s1,s2);
        System.out.println(res);
    }

    private static void preTree(String s1, String s2) {
        //boolean flg = Equ(s1,s2);
        /*if (flg == false){
            return ;
        }*/
        if (s1.length() == 0){
            return;
        }
        if (s1.length() == 1){
            res += s1;
            return;
        }
        char root = s2.charAt(s2.length()-1);
        int cur = s1.indexOf(root);
        String s = s1.substring(0,cur);
        String c = s1.substring(cur+1);
        res += String.valueOf(root);
        preTree(s,s2.substring(0,s.length()));
        preTree(c,s2.substring(s.length(),s2.length()-1));
        return;
    }

    /*private static boolean Equ(String s1, String s2) {
        boolean flg = true;
        if (s1.length() != s2.length()){
            flg = false;
        }
        if (s1.length() == s2.length()){
            for (int i = 0;i < s1.length();i++){
                if (s2.indexOf(s1.charAt(i)) == -1){
                    flg = false;
                }
            }
        }
        return flg;
    }*/
}

import java.util.Scanner;

public class Test {
    public static boolean len(String str){
        if (str == null || str.length() <= 8){
            return false;
        }
        return true;
    }
    public static boolean Three (String str){
        int num = 0;
        int lowerCase = 0;
        int upperCase = 0;
        int other = 0;
        char[] ch = str.toCharArray();
        for (int i = 0;i < ch.length;i++){
            if (ch[i] >= '0' && ch[i] <= '9'){
                num = 1;
                continue;
            }else if (ch[i] >= 'a' && ch[i] <= 'z'){
                lowerCase = 1;
                continue;
            }else if (ch[i] >= 'A' && ch[i] <= 'Z'){
                upperCase = 1;
                continue;
            }else {
                other = 1;
                continue;
            }
        }
        return (num + lowerCase + upperCase + other) >= 3 ? true : false;
    }
    public static boolean equals(String str){
        for (int i = 0;i < str.length() -2;i++){
            String s = str.substring(i,i+3);
            if (str.substring(i+1).contains(s)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String password = sc.nextLine();
            if (len(password) && Three(password) && equals(password)){
                System.out.println("OK");
            }else {
                System.out.println("NG");
            }
        }
    }
}

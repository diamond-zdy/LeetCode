import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = sc.nextInt();
            boolean b = num(a);
            if (b == false){
                System.out.println("No!");
            }else {
                System.out.println("Yes!");
            }
        }
    }
    public static boolean num (int a){
        int b = a*a;
        while (a > 0){
            int x = a%10;
            int y = b%10;
            a /= 10;
            b /= 10;
            if (x != y){
                return false;
            }
        }
        return true;
    }
}

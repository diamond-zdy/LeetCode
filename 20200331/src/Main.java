import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int n2 = n*n;
            int a = 0;
            int b = 0;
            while (n > 0){
                a += n % 10;
                n /= 10;
            }
            while (n2 > 0){
                b += n2 % 10;
                n2 /= 10;
            }
            System.out.println(a + " " + b);
        }
    }
}

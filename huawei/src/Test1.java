import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 1;
        int[] money = new int[3];
        String str = sc.nextLine();
        String[] arr = str.split(",");
        for (int i = 0; i < arr.length; i++) {
            int n = Integer.parseInt(arr[i]);
            if (n == 5 || n == 10 || n == 20){
                if(n == 5){
                    money[0]++;
                    number++;
                }else if(n == 10){
                    if(--money[0] >= 0){
                        money[1]++;
                        number++;
                    }else {
                        System.out.println("false,"+number);
                        break;
                    }
                }else {
                    if (--money[0] >= 0 && --money[1] >= 0){
                        money[2]++;
                        number++;
                    }else if(money[0] - 3 >= 0){
                        money[0] -= 3;
                        money[2]++;
                        number++;
                    }else {
                        System.out.println("false,"+number);
                        break;
                    }
                }
            }else{
                System.out.println("false,"+number);
                break;
            }
        }
        if(number == arr.length + 1){
            System.out.println("true,"+(number-1));

        }
    }
}
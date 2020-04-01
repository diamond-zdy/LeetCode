import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            double G = 0;
            int sum = 0;
            for (int i = 0;i < n; i++){
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            int[] score = new int[n];
            for (int i = 0;i < n;i++){
                score[i] = sc.nextInt();
            }
            for (int i = 0;i < n;i++){
                if (score[i] >= 90 && score[i] <= 100){
                    G += arr[i]*4.0;
                }else if (score[i] >= 85 && score[i] <= 89){
                    G += arr[i]*3.7;
                }else if (score[i] >= 82 && score[i] <= 84){
                    G += arr[i]*3.3;
                }else if (score[i] >= 78 && score[i] <= 81){
                    G += arr[i]*3.0;
                }else if (score[i] >= 75 && score[i] <= 77){
                    G += arr[i]*2.7;
                }else if (score[i] >= 72 && score[i] <= 74){
                    G += arr[i]*2.3;
                }else if (score[i] >= 68 && score[i] <= 71){
                    G += arr[i]*2.0;
                }else if (score[i] >= 64 && score[i] <= 67){
                    G += arr[i]*1.5;
                }else if (score[i] >= 60 && score[i] <= 63){
                    G += arr[i]*1.0;
                }else if (score[i] < 60){
                    G += arr[i]*0;
                }
            }
            System.out.printf("%.2f",G/sum);
        }
    }
}

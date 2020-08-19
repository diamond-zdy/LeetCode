import java.util.Scanner;
//给定三个坐标，求是否为三角形，若是三角形输出周长和面积
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0;i < 6;i++){
            arr[i] = sc.nextInt();
        }
        double a = Math.sqrt(Math.pow((arr[0]-arr[2]),2)+Math.pow((arr[1]-arr[3]),2));
        double b = Math.sqrt(Math.pow((arr[0]-arr[4]),2)+Math.pow((arr[1]-arr[5]),2));
        double c = Math.sqrt(Math.pow((arr[4]-arr[2]),2)+Math.pow((arr[5]-arr[3]),2));
        double p = (a+b+c)/2;
        if (a+b>c && a+c>b && c+b > a){
            System.out.printf("%.2f",(a + b + c));
            System.out.println();
            double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
            System.out.printf("%.2f" , s);
        }else {
            System.out.println("Impossible");
        }
    }
}

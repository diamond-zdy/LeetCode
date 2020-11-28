import java.util.Scanner;
/*计算糖果
A,B,C,三个人是好朋友，每人手里有一些糖果，不知道三人手里具体有多少个，但知道以下信息：
A-B,B-C,A+B,B+C这四个数值，每个字母代表每个人拥有的糖果数
通过四个数值计算每个人手里有多少个糖果
输入描述：
输入为一行，一共四个整数，分别为A-B,B-C,A+B,B+C，用空格隔开。范围均在-30到30之间（闭区间）
输出描述：
输出为一行，如果存在满足的ABC则输出，用空格隔开，如果不存在，输出No*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int a = (X+P)/2;
        int b = (Y+Q)/2;
        if ((X+P)%2 == 0 &&(Y+Q)% 2 == 0 && b-Y == Q-b && (a+b) == P){
            System.out.println(a+" "+b+" "+(b-Y));
        }else {
            System.out.println("No");
        }
    }
}

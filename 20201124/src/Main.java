import java.util.Scanner;
/*汽水瓶
某商店规定三个空汽水瓶可以换一瓶契税。校长手上有是个空汽水瓶，他最多可以换多少瓶汽水喝？答案是5瓶，方法如下，
先用9个空瓶换3瓶汽水，喝掉3瓶慢的，喝完以后四个瓶子，用三个再换一瓶，现在还有2个空瓶，让老板借你一瓶汽水，喝掉后用
3个空瓶还给老板，所以最多喝5瓶。
输入描述：一行一个数据，最多包含十组数据，n=0表示输入结束，程序不应当处理这一行。*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int res = 0;
            int k,y;
            while (n >= 3){
                k = n/3;
                y = n % 3;
                res += k;
                n = k+y;
            }
            if (n == 2){
                res += 1;
            }
            if (n != 0)
            System.out.println(res);
        }
    }
}

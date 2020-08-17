import java.util.Scanner;
//假如有编号为1~3的3张扑克牌和编号为1~3的三个盒子，现在需要将3张扑克牌分别放到3个盒子中，
// 且每个盒子只能放一张，一共有多少种不同的方法
public class Test {
    public static void dfs(int index,int n,int[] box,int[] book){
        if (index == n+1){
            for (int i = 1;i <= n;i++){
                System.out.print(box[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1;i <= n;i++){
            if (book[i] == 0){
                box[index] = i;
                book[i] = 1;//现在第i号已被占用
                //处理下一个盒子
                dfs(index+1,n,box,book);
                //回退
                book[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] box = new int[n+1];
        int[] book = new int[n+1];
        dfs(1,n,box,book);
    }
}

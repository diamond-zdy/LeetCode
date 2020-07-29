//各不相同
//        时间限制： 3000MS
//        内存限制： 589824KB
//        题目描述：
//        我们希望一个序列中的元素是各不相同的，但是理想和现实往往是有差距的。
//        现在给出一个序列A，其中难免有些相同的元素，现在提供了一种变化方式，使得经过若干次操作后一定可以得到一个元素各不相同的序列。
//
//        这个操作是这样的，令x为序列中最小的有重复的数字，你需要删除序列左数第一个x，并把第二个x替换为2*x。
//        请你输出最终的序列。
//
//        例如原序列是[2,2,1,1,1],一次变换后变为[2,2,2,1]，两次变换后变为[4,2,1]，变换结束
//
//        输入描述
//        输入第一行包含一个正整数n，表示序列的长度为n。(1<=n<=50000)
//        第二行有n个整数，初始序列中的元素。(1<=a_i<=10^8)
//
//        输出描述
//        输出包含若干个整数，即最终变换之后的结果。
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0;i < n;i++){
                arr[i] = sc.nextInt();
            }
            boolean flg = true;
            while (flg){
                flg = remove(arr,n);
            }
            for (int i = 0;i < n-1;i++){
                if (arr[i] > 0){
                    System.out.print(arr[i] + " ");
                }
            }
            if (arr[n-1] > 0){
                System.out.println(arr[n-1]);
            }
        }
    }
    public static boolean remove(int[] arr,int n){
        int min = -1;
        int count = 1;
        boolean flg = false;
        for (int i = n-1;i > 0;i--){
            for (int j = i-1;j>=0;j--){
                if (arr[i] == arr[j] && arr[i] != 0){
                    min = arr[i];
                    flg = true;
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min && count == 1){
                arr[i] = 0;
                count++;
            }else if (arr[i] == min && count == 2){
                arr[i] *= 2;
                break;
            }
        }
        return flg;
    }
}
